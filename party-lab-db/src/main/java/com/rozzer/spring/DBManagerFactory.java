package com.rozzer.spring;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.rozzer.common.Saved;
import com.rozzer.manager.Manager;
import com.rozzer.manager.ManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DBManagerFactory implements ManagerFactory {

    private List<Manager<? extends Saved>> objectManagersBeans;
    private HashMap<Type, Manager> objectManagers = Maps.newHashMapWithExpectedSize(9);



    @Autowired
    public void setObjectManagersBeans(List<Manager<? extends Saved>> objectManagersBeans) {
        this.objectManagersBeans = objectManagersBeans;
    }

    public <U extends Saved> Manager<U> getManager(Class<U> clazz) {
        Manager manager = objectManagers.get(clazz);
        if (manager == null) {
            manager = findManager(Lists.newArrayList(new ObjManTypesafeGarant(clazz), new ObjManTypesafeGarant2(clazz)).iterator());
            objectManagers.put(clazz, manager);
        }
        return manager;
    }

    public void register(Class<? extends Saved> clazz, Manager manager) {
        objectManagers.put(clazz, manager);
    }

    /**
     * finds manager by predicate
     *
     * @param typesafeGarants should check if manager can be casted to ObjectManager<T>
     * @param <T>
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    private <T extends Saved> Manager<T> findManager(@Nonnull Iterator<Predicate<Manager>> typesafeGarants) {
        Set<Manager<? extends Saved>> candidates = null;
        Predicate<Manager> typesafeGarant = null;
        while (CollectionUtils.isEmpty(candidates) && typesafeGarants.hasNext()) {
            typesafeGarant = typesafeGarants.next();
            candidates = objectManagersBeans.stream().filter(typesafeGarant).collect(Collectors.toSet());
        }
        if (CollectionUtils.isEmpty(candidates))
            throw new RuntimeException(String.format("Object manager '%s' not found. Available managers: %s", typesafeGarant, objectManagersBeans));
        if (candidates.size() > 1)
            throw new RuntimeException(String.format("Got multiple candidates for '%s'. Candidates are: %s", typesafeGarant, candidates));
        Manager<? extends Saved> found = candidates.iterator().next();
        try {
            return (Manager<T>) found;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Typesafe garant '%s' assumes that '%s' has proper type. But it has not", typesafeGarant, found), e);
        }
    }


    private static class ObjManTypesafeGarant implements Predicate<Manager> {

        private final Type storableType;

        private ObjManTypesafeGarant(Type type) {
            this.storableType = type;
        }

        @Override
        public boolean test(Manager input) {
            Type managersGenericType = TypeToken.of(input.getClass())
                    .resolveType(Manager.class.getTypeParameters()[0]).getType();
            return storableType.equals(managersGenericType);
        }

        @Override
        public String toString() {
            return String.format("%s<%s>", Manager.class.getSimpleName(), storableType);
        }
    }

    private static class ObjManTypesafeGarant2 implements Predicate<Manager> {

        private final Type storableType;

        private ObjManTypesafeGarant2(Type type) {
            this.storableType = type;
        }

        @Override
        public boolean test(Manager input) {
            return TypeToken.of(input.getClass())
                    .resolveType(Manager.class.getTypeParameters()[0]).isSupertypeOf(storableType);
        }

        @Override
        public String toString() {
            return String.format("%s<? extends %s>", Manager.class.getSimpleName(), storableType);
        }
    }
}

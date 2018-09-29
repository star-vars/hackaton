package com.rozzer;


import com.google.common.collect.Maps;
import com.rozzer.common.Saved;
import com.rozzer.manager.Manager;
import com.rozzer.manager.ManagerFactory;

import java.util.Map;

public class DBManagerFactory implements ManagerFactory {

    private Map<Class<? extends Saved>, Manager> managers = Maps.newHashMap();

    public <U extends Saved> Manager<U> getManager(Class<U> clazz) {
        return managers.get(clazz);
    }

    public void register(Class<? extends Saved> clazz, Manager manager) {
        managers.put(clazz, manager);
    }
}

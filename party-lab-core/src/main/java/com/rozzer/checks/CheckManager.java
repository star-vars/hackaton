package com.rozzer.checks;

import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope(value = "singleton")
public class CheckManager {

    public CheckManager(@Autowired CheckConfiguration configuration) {
        checksByTheme = configuration.getChecksByThemes();
    }

    private Map<Theme, List<Class<? extends Check>>> checksByTheme;

    public List<Check> getChecks(UserProject userProject) {
        Set<Class<? extends Check>> preresult = new HashSet<>();
        userProject.getProject().getThemes().forEach(theme -> {
            List<Class<? extends Check>> classes = checksByTheme.get(theme);
            preresult.addAll(classes);
        });
        List<Class<? extends Check>> preresultClasses = new ArrayList<>(preresult);
        preresultClasses.sort(Comparator.comparingInt(CheckManager::getAnnotationOrder));
        List<Check> result = new ArrayList<>();
        preresultClasses.forEach(aClass -> {
            try {
                Check check = aClass.newInstance();
                check.setProject(userProject);
                result.add(check);
            } catch (InstantiationException | IllegalAccessException ignored) {}
        });
        return result;
    }

    private static int getAnnotationOrder(Class clazz) {
        CheckOrder annotation = (CheckOrder) clazz.getAnnotation(CheckOrder.class);
        if (annotation == null) {
            return 0;
        } else {
            return annotation.value();
        }
    }

}

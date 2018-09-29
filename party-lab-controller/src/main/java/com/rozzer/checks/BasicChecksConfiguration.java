package com.rozzer.checks;

import com.google.common.collect.Maps;
import com.rozzer.checks.impl.*;
import com.rozzer.model.Theme;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.rozzer.controller.common.ControllerHelper.manager;

@Configuration
public class BasicChecksConfiguration implements CheckConfiguration {

    public static final long JAVA_THEME_ID = 1;

    @Override
    public Map<Theme, List<Class<? extends Check>>> getChecksByThemes() {
        Map<Theme, List<Class<? extends Check>>> map = Maps.newHashMap();
        Optional<Theme> theme = manager(Theme.class).getById(JAVA_THEME_ID);
        Theme java = theme.orElseGet(() -> {
            Theme t = manager(Theme.class).create();
            t.setName("Java");
            manager(Theme.class).save(t);
            return t;
        });
        List<Class<? extends Check>> javaChecks = new ArrayList<>();
        javaChecks.add(ProjectHasDesignCheck.class);
        javaChecks.add(ProjectHasArchitectureCheck.class);
        javaChecks.add(ProjectHasTestCasesCheck.class);
        javaChecks.add(ProjectHasAutotestsByTestCasesCheck.class);
        javaChecks.add(ProjectHasCodePassingAutotestsCheck.class);
        map.put(java, javaChecks);
        return map;
    }
}

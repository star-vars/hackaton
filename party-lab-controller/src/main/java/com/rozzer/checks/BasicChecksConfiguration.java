package com.rozzer.checks;

import com.google.common.collect.Maps;
import com.rozzer.checks.impl.*;
import com.rozzer.model.Theme;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.rozzer.controller.common.ControllerHelper.manager;

@Configuration
@DependsOn("themeManager")
public class BasicChecksConfiguration implements CheckConfiguration {

    @Override
    public Map<Theme, List<Class<? extends Check>>> getChecksByThemes() {
        Map<Theme, List<Class<? extends Check>>> map = Maps.newHashMap();
        List<Theme> themes = manager(Theme.class).getByName("Java");
        Theme theme;
        if (themes.size() == 0) {
            theme = manager(Theme.class).create();
            theme.setName("Java");
            manager(Theme.class).save(theme);
        } else {
            theme = themes.get(0);
        }
        List<Class<? extends Check>> javaChecks = new ArrayList<>();
        javaChecks.add(ProjectHasDesignCheck.class);
        javaChecks.add(ProjectHasArchitectureCheck.class);
        javaChecks.add(ProjectHasTestCasesCheck.class);
        javaChecks.add(ProjectHasAutotestsByTestCasesCheck.class);
        javaChecks.add(ProjectHasCodePassingAutotestsCheck.class);
        map.put(theme, javaChecks);
        return map;
    }
}

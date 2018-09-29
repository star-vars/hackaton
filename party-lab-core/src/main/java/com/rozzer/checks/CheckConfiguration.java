package com.rozzer.checks;

import com.rozzer.model.Theme;

import java.util.List;
import java.util.Map;

public interface CheckConfiguration {

    Map<Theme, List<Class<? extends Check>>> getChecksByThemes();

}

package com.rozzer.checks;

import java.util.List;
import java.util.Map;

public interface CheckConfiguration {

    Map<String, List<Class<? extends Check>>> getChecksByThemes();

}

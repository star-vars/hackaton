package com.rozzer.validate;

import com.google.common.collect.Maps;
import com.rozzer.common.CaseType;
import com.rozzer.validate.cucumber.CucumberEngine;

import java.util.Map;
import java.util.Optional;

class TestEngineFactory {

    private static final Map<CaseType, TestEngine> FACTORY = Maps.newHashMap();

    static {
        FACTORY.put(CaseType.USE_CASE, new CucumberEngine());
    }

    static Optional<TestEngine> getEngine(CaseType type){
        return Optional.ofNullable(FACTORY.get(type));
    }

}

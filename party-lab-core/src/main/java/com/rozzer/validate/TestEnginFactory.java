package com.rozzer.validate;

import com.google.common.collect.Maps;
import com.rozzer.common.CaseType;
import com.rozzer.validate.cucumber.CucumberEngine;

import java.util.Map;

public class TestEnginFactory {

    private static final Map<CaseType, TestEngine> FACTORY = Maps.newHashMap();

    static {
        FACTORY.put(CaseType.USE_CASE, new CucumberEngine());
    }

    public static TestEngine getEngine(CaseType type){
        return FACTORY.get(type);
    }

}

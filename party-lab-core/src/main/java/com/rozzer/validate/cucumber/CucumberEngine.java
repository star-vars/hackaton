package com.rozzer.validate.cucumber;

import com.rozzer.model.Case;
import com.rozzer.validate.Status;
import com.rozzer.validate.TestEngine;

import java.util.Random;

public class CucumberEngine implements TestEngine {


    //TODO This is stab for validation
    @Override
    public Status checkCase(Case aCase) {
        String caseBody = aCase.getBody();
        new CucumberTest().test(caseBody);
        int pick = new Random().nextInt(Status.values().length);
        return Status.values()[pick];
    }
}

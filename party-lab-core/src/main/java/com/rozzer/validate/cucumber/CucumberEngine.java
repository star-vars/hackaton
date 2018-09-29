package com.rozzer.validate.cucumber;

import com.rozzer.model.Case;
import com.rozzer.validate.Status;
import com.rozzer.validate.TestEngine;
import org.json.simple.JSONObject;

import java.util.Random;

public class CucumberEngine implements TestEngine {


    //TODO This is stab for validation
    @Override
    public Status checkCase(Case aCase) {
        JSONObject caseBody = aCase.getCaseBody();
        if (caseBody instanceof CucumberCase){
            new CucumberTest().test((CucumberCase) caseBody);
        }
        int pick = new Random().nextInt(Status.values().length);
        return Status.values()[pick];
    }
}

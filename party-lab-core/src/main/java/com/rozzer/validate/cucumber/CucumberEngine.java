package com.rozzer.validate.cucumber;

import com.rozzer.model.Case;
import com.rozzer.model.UserProject;
import com.rozzer.validate.Report;
import com.rozzer.validate.Status;
import com.rozzer.validate.TestEngine;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Random;

public class CucumberEngine implements TestEngine {


    @Override
    public Report checkProject(UserProject userProject) {
        List<Case> cases = userProject.getProject().getCases();
        Report report = new Report();
        for (Case aCase : cases) {
            report.addCase(validate(aCase), aCase);
        }
        return report;
    }

    //TODO This is stab for validation
    private Status validate(Case aCase) {
        JSONObject caseBody = aCase.getCaseBody();
        if (caseBody instanceof CucumberCase){
            new CucumberTest().test((CucumberCase) caseBody);
        }
        int pick = new Random().nextInt(Status.values().length);
        return Status.values()[pick];
    }
}

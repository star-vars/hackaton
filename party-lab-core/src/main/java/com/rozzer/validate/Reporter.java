package com.rozzer.validate;

import com.rozzer.model.Case;
import com.rozzer.model.UserProject;

import java.util.List;

public class Reporter {

    private static Reporter instance = new Reporter();

    public static Reporter getInstance() {
        return instance;
    }


    public Report checkProject(UserProject userProject) {
        List<Case> cases = userProject.getProject().getCases();
        Report report = new Report();
        for (Case aCase : cases) {
            TestEngineFactory.getEngine(aCase.getType()).checkCase(aCase);
        }
        return report;
    }

}

package com.rozzer.checks.impl.inner;

import com.rozzer.checks.SimpleCheck;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.checks.result.SimpleCheckResult;
import com.rozzer.model.Case;
import com.rozzer.session.SessionData;

import java.util.List;

public class ProjectHasAutotestByTestCaseCheck extends SimpleCheck {

    private List<Case> casesInProject;

    @Override
    public CheckResult performCheck(int iteration, SessionData sessionData) {
        casesInProject.size();
        if (iteration % 2 == 0) {
            return SimpleCheckResult.PASSED;
        } else {
            return SimpleCheckResult.FAILED;
        }
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getId() {
        return "at-inner-check";
    }

    public void setCasesInProject(List<Case> casesInProject) {
        this.casesInProject = casesInProject;
    }
}

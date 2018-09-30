package com.rozzer.checks.impl;

import com.rozzer.checks.CheckOrder;
import com.rozzer.checks.SimpleCheck;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.checks.result.SimpleCheckResult;
import com.rozzer.model.ProjectStructure;
import com.rozzer.service.UserProjectService;
import com.rozzer.session.SessionData;

@CheckOrder(2)
public class ProjectHasTestCasesCheck extends SimpleCheck {
    @Override
    public CheckResult performCheck(int iteration, SessionData sessionData) {
        new UserProjectService().collectUserProjectCases(getProject(), sessionData);
        if (getProject().getUserCases().size() > 0) {
            return SimpleCheckResult.PASSED;
        } else {
            return SimpleCheckResult.FAILED;
        }
    }

    @Override
    public String getDescription() {
        return "This check performs validation of existence of files in directory " + ProjectStructure.TEST_CASES_FOLDER;
    }

    @Override
    public String getId() {
        return "testcases-check";
    }
}

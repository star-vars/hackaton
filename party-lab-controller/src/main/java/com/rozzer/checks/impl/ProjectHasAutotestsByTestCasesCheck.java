package com.rozzer.checks.impl;

import com.rozzer.checks.CheckOrder;
import com.rozzer.checks.RepeatableCheck;
import com.rozzer.checks.impl.inner.ProjectHasAutotestByTestCaseCheck;
import com.rozzer.model.ProjectStructure;
import com.rozzer.service.UserProjectService;
import com.rozzer.session.SessionData;

@CheckOrder(3)
public class ProjectHasAutotestsByTestCasesCheck extends RepeatableCheck {

    public ProjectHasAutotestsByTestCasesCheck() {
        super(new ProjectHasAutotestByTestCaseCheck());
    }

    @Override
    public String getDescription() {
        return "This check performs validation that autotests in folder " + ProjectStructure.SRC_TESTS_FOLDER + " are valid";
    }

    @Override
    public String getId() {
        return "autotests-check";
    }

    @Override
    protected int computeCapacity(SessionData sessionData) {
        new UserProjectService().collectUserProjectCases(getProject(), sessionData);
        return getProject().getUserCases().size();
    }
}

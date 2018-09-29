package com.rozzer.checks.impl;

import com.rozzer.checks.CheckOrder;
import com.rozzer.checks.RepeatableCheck;
import com.rozzer.checks.impl.inner.ProjectHasAutotestByTestCaseCheck;
import com.rozzer.model.Case;
import com.rozzer.model.ProjectStructure;

import java.util.ArrayList;
import java.util.List;

@CheckOrder(3)
public class ProjectHasAutotestsByTestCasesCheck extends RepeatableCheck {

    public ProjectHasAutotestsByTestCasesCheck() {
        super(new ProjectHasAutotestByTestCaseCheck());
    }

    private List<Case> casesInProject = new ArrayList<>();

    @Override
    public String getDescription() {
        return "This check performs validation that autotests in folder " + ProjectStructure.SRC_TESTS_FOLDER + " are valid";
    }

    @Override
    public String getId() {
        return "autotests-check";
    }

    @Override
    protected int computeCapacity() {
        ((ProjectHasAutotestByTestCaseCheck)innerCheck).setCasesInProject(casesInProject);
        return 5;
    }
}

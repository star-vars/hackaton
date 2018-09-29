package com.rozzer.checks.impl;

import com.rozzer.checks.CheckOrder;
import com.rozzer.checks.ComplexCheck;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.checks.result.ComplexCheckResult;
import com.rozzer.checks.result.SimpleCheckResult;
import com.rozzer.model.Case;
import com.rozzer.session.SessionData;
import com.rozzer.validate.Report;
import com.rozzer.validate.Reporter;
import com.rozzer.validate.Status;
import javafx.util.Pair;

import java.util.List;

@CheckOrder(4)
public class ProjectHasCodePassingAutotestsCheck extends ComplexCheck {

    @Override
    public CheckResult performCheck(int iteration, SessionData sessionData) {
        List<Pair<Status, Case>> report = Reporter.getInstance().checkProject(getProject()).getReport();
        ComplexCheckResult checkResult = new ComplexCheckResult(report.size());
        report.forEach(statusCasePair -> {
            if (statusCasePair.getKey().equals(Status.SUCCESS)) {
                checkResult.getResults().add(SimpleCheckResult.PASSED);
            } else {
                checkResult.getResults().add(SimpleCheckResult.FAILED);
            }
        });
        return checkResult;
    }

    @Override
    public String getDescription() {
        return "This check performs validation that all autotests are passing during build";
    }

    @Override
    public String getId() {
        return "code-pass-check";
    }
}

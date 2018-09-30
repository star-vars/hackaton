package com.rozzer.checks;

import com.rozzer.checks.result.ComplexCheckResult;
import com.rozzer.session.SessionData;

public abstract class RepeatableCheck extends ComplexCheck {

    protected Check innerCheck;

    public RepeatableCheck(Check innerCheck) {
        this.innerCheck = innerCheck;
    }

    protected abstract int computeCapacity(SessionData sessionData);

    public final ComplexCheckResult performCheck(int iteration, SessionData sessionData) {
        innerCheck.setProject(getProject());
        ComplexCheckResult complexCheckResult = new ComplexCheckResult(computeCapacity(sessionData));
        for (int i = 0; i < complexCheckResult.getCapacity(); i++) {
            complexCheckResult.getResults().add(innerCheck.performCheck(i, sessionData));
        }
        return complexCheckResult;
    }
}

package com.rozzer.checks;

import com.rozzer.checks.result.CheckResult;
import com.rozzer.model.UserProject;
import com.rozzer.session.SessionData;

public interface Check {

    UserProject getProject();

    void setProject(UserProject project);

    CheckResult performCheck(int iteration, SessionData sessionData);

    default CheckResult performCheck(SessionData sessionData) {
        return performCheck(0, sessionData);
    }

    String getDescription();

    String getId();

}

package com.rozzer.checks;

import com.rozzer.model.UserProject;

public abstract class AbstractCheck implements Check {

    private UserProject project;

    @Override
    public UserProject getProject() {
        return project;
    }

    @Override
    public void setProject(UserProject project) {
        this.project = project;
    }
}

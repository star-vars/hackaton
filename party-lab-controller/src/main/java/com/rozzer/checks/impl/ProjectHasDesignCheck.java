package com.rozzer.checks.impl;

import com.rozzer.checks.CheckOrder;
import com.rozzer.checks.SimpleCheck;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.checks.result.SimpleCheckResult;
import com.rozzer.model.ProjectStructure;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.ContentsService;

import java.io.IOException;
import java.util.List;

@CheckOrder(0)
public class ProjectHasDesignCheck extends SimpleCheck {
    @Override
    public CheckResult performCheck(int iteration, SessionData sessionData) {
        try {
            ContentsService contentsService = new ContentsService(sessionData.getGhClient());
            List<RepositoryContents> contents = contentsService.getContents(RepositoryId.create(sessionData.getUser().getLogin(), getProject().getRepo()), ProjectStructure.DESIGN_FOLDER);
            if (contents.size() > 0) {
                return SimpleCheckResult.PASSED;
            } else {
                return SimpleCheckResult.FAILED;
            }
        } catch (IOException e) {
            return SimpleCheckResult.FAILED;
        }
    }

    @Override
    public String getDescription() {
        return "This check performs validation of existence of files in directory " + ProjectStructure.DESIGN_FOLDER;
    }

    @Override
    public String getId() {
        return "design-check";
    }

}

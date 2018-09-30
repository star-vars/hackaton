package com.rozzer.checks.impl.inner;

import com.rozzer.checks.SimpleCheck;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.checks.result.SimpleCheckResult;
import com.rozzer.model.Case;
import com.rozzer.model.ProjectStructure;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.RequestException;
import org.eclipse.egit.github.core.service.ContentsService;

import java.io.IOException;
import java.util.List;

public class ProjectHasAutotestByTestCaseCheck extends SimpleCheck {

    @Override
    public CheckResult performCheck(int iteration, SessionData sessionData) {
        try {
            Case aCase = getProject().getUserCases().get(iteration);
            String caseFileName = aCase.getFileName().replace(ProjectStructure.TEST_CASES_FOLDER, ProjectStructure.SRC_TESTS_FOLDER);
            ContentsService contentsService = new ContentsService(sessionData.getGhClient());
            List<RepositoryContents> contents = contentsService.getContents(
                    RepositoryId.create(getProject().getUser().getLogin(), getProject().getRepo()),
                    caseFileName
            );
            if (contents.get(0).getSize() > 0) {
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
        return null;
    }

    @Override
    public String getId() {
        return "at-inner-check";
    }

}

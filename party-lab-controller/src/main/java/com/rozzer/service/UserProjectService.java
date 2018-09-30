package com.rozzer.service;

import com.google.common.base.Splitter;
import com.rozzer.common.CaseType;
import com.rozzer.model.Case;
import com.rozzer.model.ProjectStructure;
import com.rozzer.model.UserProject;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserProjectService {

    @Autowired
    private SessionData sessionData;

    public void collectUserProjectCases(UserProject project) {
        collectUserProjectCases(project, sessionData);
    }

    public void collectUserProjectCases(UserProject project, SessionData sessionData) {
        try {
            project.setUserCases(new ArrayList<>());
            ContentsService contentsService = new ContentsService(sessionData.getGhClient());
            RepositoryId repoId = RepositoryId.create(sessionData.getUser().getLogin(), project.getRepo());
            List<RepositoryContents> contents = contentsService.getContents(repoId, ProjectStructure.TEST_CASES_FOLDER);
            contents.forEach(repositoryContents -> {
                Case tCase = new Case();
                tCase.setType(CaseType.TEST_CASE);
                try {
                    tCase.setBody(new String(Base64.getDecoder().decode(repositoryContents.getContent()), repositoryContents.getEncoding()));
                } catch (UnsupportedEncodingException e) {
                    tCase.setBody(new String(Base64.getDecoder().decode(repositoryContents.getContent())));
                }
                tCase.setFileName(repositoryContents.getPath());
                tCase.setName(Splitter.on(Pattern.compile("\\n")).omitEmptyStrings().trimResults().split(tCase.getBody()).iterator().next());
            });
        } catch (IOException ignored) {
        }
    }

}

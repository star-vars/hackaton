package com.rozzer.controller;

import com.rozzer.checks.Check;
import com.rozzer.checks.CheckManager;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.common.WorkStatus;
import com.rozzer.controller.common.EntityController;
import com.rozzer.manager.UserProjectManager;
import com.rozzer.model.Project;
import com.rozzer.model.UserProject;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RequestMapping(value = "/userproject")
@RestController
public class UserProjectController implements EntityController<UserProject> {

    @Autowired
    private SessionData sessionData;

    @Autowired
    private CheckManager checkManager;

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserProject> getAll() {
        return manager(UserProject.class).getAll();
    }

    @RequestMapping(value = "pick", method = RequestMethod.POST)
    public UserProject createFromProject(Project project) {
        try {
            RepositoryService repositoryService = new RepositoryService(sessionData.getGhClient());
            String prName = sessionData.getUser().getName() + " " + project.getName();
            Repository repository = repositoryService.forkRepository(
                    RepositoryId.create(project.getCustomer().getLogin(), project.getRepo())
            );
            UserProject userProject = manager(UserProject.class).create();
            userProject.setName(prName);
            userProject.setUser(sessionData.getUser());
            userProject.setRepo(repository.getName());
            userProject.setRepoUrl(repository.getUrl());
            manager(UserProject.class).save(userProject);
            return userProject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public UserProject create() {
        return manager(UserProject.class).create();
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public UserProject read(@PathVariable String id) {
        return manager(UserProject.class).getById(new Long(id)).orElse(new UserProject());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(UserProject object) {
        manager(UserProject.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(UserProject object) {
        manager(UserProject.class).delete(object);
    }

    @RequestMapping(value = "myByStatus/{status}", method = RequestMethod.GET)
    public List<UserProject> myByStatus(@PathVariable WorkStatus status) {
        return manager(UserProject.class, UserProjectManager.class).findByUserAndStatus(sessionData.getUser(), status);
    }

    @RequestMapping(value = "projectPhases/{projectId}")
    public Map<String, CheckResult> checkProjectPhases(@PathVariable Long projectId) {
        Optional<UserProject> project = manager(UserProject.class).getById(projectId);
        Map<String, CheckResult> results = new HashMap<>();
        if (project.isPresent()) {
            checkManager.getChecks(project.get()).forEach(check -> results.put(check.getId(), check.performCheck(sessionData)));
            return results;
        } else {
            return Collections.emptyMap();
        }
    }
}

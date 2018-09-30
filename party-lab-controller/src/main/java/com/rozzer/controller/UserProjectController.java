package com.rozzer.controller;

import com.rozzer.checks.CheckManager;
import com.rozzer.checks.result.CheckResult;
import com.rozzer.common.WorkStatus;
import com.rozzer.controller.common.EntityController;
import com.rozzer.manager.UserProjectManager;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import com.rozzer.service.ListResult;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RequestMapping(value = "/api/userproject")
@RestController
public class UserProjectController implements EntityController<UserProject> {

    private SessionData sessionData;

    private CheckManager checkManager;

    @Autowired
    public UserProjectController(SessionData sessionData, CheckManager checkManager) {
        this.sessionData = sessionData;
        this.checkManager = checkManager;
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserProject> getAll() {
        return manager(UserProject.class).getAll();
    }

    @RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
    public ListResult<UserProject> getAllByPage(@PathVariable Integer page) {
        return ListResult.of(manager(UserProject.class)
                .getAllByPage(
                        EntityController.createPage(page, 4)), manager(UserProject.class)
                .countAll());
    }

    @RequestMapping(value = "pick/{projectId}", method = RequestMethod.GET)
    public UserProject createFromProject(@PathVariable Long projectId) {
        Project project = manager(Project.class).getById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found by id:" + projectId));
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
    public UserProject update(UserProject object) {
        return manager(UserProject.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(UserProject object) {
        manager(UserProject.class).delete(object);
    }

    @RequestMapping(value = "myByStatus/{status}", method = RequestMethod.GET)
    public List<UserProject> myByStatus(@PathVariable WorkStatus status) {
        return manager(UserProject.class, UserProjectManager.class)
                .findByUserAndStatus(sessionData.getUser(), status);
    }

    @RequestMapping(value = "myByStatus/all", method = RequestMethod.GET)
    public List<UserProject> myByStatus() {
        return manager(UserProject.class, UserProjectManager.class)
                .findByUser(sessionData.getUser());
    }

    @RequestMapping(value = "projectPhases/{projectId}")
    public Map<String, CheckResult> checkProjectPhases(@PathVariable Long projectId) {
        Optional<UserProject> project = manager(UserProject.class).getById(projectId);
        Map<String, CheckResult> results = new HashMap<>();
        if (!project.isPresent()) {
            return Collections.emptyMap();
        }
        checkManager.getChecks(project.get())
                .forEach(check -> results.put(check.getId(), check.performCheck(sessionData)));
        return results;
    }

    @GetMapping("/theme/{theme}")
    public List<UserProject> getUserProjectByThemes(@PathVariable String theme) {
        List<Theme> themeList = manager(Theme.class).getByName(theme);
        Theme aTheme = themeList.stream().findFirst().orElse(new Theme(theme));
        return manager(UserProject.class, UserProjectManager.class).findByTheme(aTheme);
    }
}

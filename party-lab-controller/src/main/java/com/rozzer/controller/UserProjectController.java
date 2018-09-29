package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.controller.oauth.SessionData;
import com.rozzer.model.Project;
import com.rozzer.model.UserProject;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RequestMapping(value = "userproject")
public class UserProjectController implements Controller<UserProject> {

    @Autowired
    private SessionData sessionData;

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserProject> getAll() {
        return manager(UserProject.class).getAll();
    }

    @RequestMapping(value = "pick", method = RequestMethod.POST)
    public UserProject createFromProject(Project project) {
        try {
            RepositoryService repositoryService = new RepositoryService();
            repositoryService.getClient().setOAuth2Token(sessionData.getAccessToken());
            String prName = sessionData.getUser().getName() + " " + project.getName();
            Repository repository = repositoryService.createRepository(new Repository().setName(prName));
            UserProject userProject = manager(UserProject.class).create();
            userProject.setName(prName);
            userProject.setUser(sessionData.getUser());
            userProject.setRepo(repository.generateId());
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
    @RequestMapping(method = RequestMethod.GET)
    public UserProject read(String id) {
        return manager(UserProject.class).getById(new Long(id));
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
}

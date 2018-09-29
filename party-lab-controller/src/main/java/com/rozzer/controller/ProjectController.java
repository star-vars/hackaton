package com.rozzer.controller;


import com.google.gson.Gson;
import com.rozzer.controller.common.EntityController;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.ProjectManager;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/project")
public class ProjectController implements EntityController<Project> {

    @Autowired
    private SessionData sessionData;

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> getAll() {
        return manager(Project.class).getAll();
    }

    @RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
    public String getAllByPage(@PathVariable String page) {
        return "{\"size\": " + manager(Project.class).getAll().size() + ", \"projects\" :" +
                new Gson().toJson(manager(Project.class).getAllByPage(Integer.valueOf(page))) +"}";
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Project create() {
        return manager(Project.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Project read(String id) {
        return manager(Project.class).getById(new Long(id)).orElse(new Project());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(Project object) {
        try {
            RepositoryService repositoryService = new RepositoryService();
            Repository repository = repositoryService.getRepository(sessionData.getUser().getLogin(), object.getRepo());
            if (repository == null) {
                repository = repositoryService.createRepository(new Repository().setName(object.getRepo()));
            }
            object.setRepoUrl(repository.getUrl());
            manager(Project.class).save(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Project object) {
        manager(Project.class).delete(object);
    }

    @GetMapping("/theme{theme}")
    public List<Project> getProjectByThemes(@RequestParam String theme) {
        List<Theme> themeList = CoreObjectManager.getInstance().getManager(Theme.class).getByName(theme);
        Theme aTheme = themeList.stream().findFirst().orElse(new Theme(theme));
        return manager(Project.class, ProjectManager.class).findByTheme(aTheme);
    }

}

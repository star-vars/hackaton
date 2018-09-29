package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Project;
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
public class ProjectController implements Controller<Project> {

    @Autowired
    private SessionData sessionData;

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> getAll() {
        return manager(Project.class).getAll();
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

    @GetMapping("/themes")
    public List<Project> getProjectByThemes(@RequestParam String themes) {
//        Iterable<String> themNames = Splitter.on(',').trimResults().split(themes);
//        manager(Project.class).getByThems()
        throw new UnsupportedOperationException("not implemented yet");
    }

}

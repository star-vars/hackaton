package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/project")
public class ProjectController implements Controller<Project> {

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
        return manager(Project.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(Project object) {
        manager(Project.class).save(object);
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

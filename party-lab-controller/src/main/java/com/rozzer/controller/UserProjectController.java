package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.UserProject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RequestMapping(value = "userproject")
public class UserProjectController implements Controller<UserProject> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserProject> getAll() {
        return manager(UserProject.class).getAll();
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

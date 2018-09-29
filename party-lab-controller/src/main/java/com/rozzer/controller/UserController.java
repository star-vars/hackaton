package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/user")
public class UserController implements Controller<User> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return manager(User.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public User create() {
        return manager(User.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public User read(String id) {
        return manager(User.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(User object) {
        manager(User.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(User object) {
        manager(User.class).delete(object);
    }
}

package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.PLUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/user")
public class UserController implements Controller<PLUser> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PLUser> getAll() {
        return manager(PLUser.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public PLUser create() {
        return manager(PLUser.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public PLUser read(String id) {
        return manager(PLUser.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(PLUser object) {
        manager(PLUser.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(PLUser object) {
        manager(PLUser.class).delete(object);
    }
}

package com.rozzer.controller;

import com.rozzer.controller.common.EntityController;
import com.rozzer.model.PLUser;
import com.rozzer.session.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/api/users")
public class UserController implements EntityController<PLUser> {

    @Autowired
    private SessionData sessionData;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public  PLUser getMe(){
        return sessionData.getUser();
    }

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
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public PLUser read(@PathVariable String id) {
        return manager(PLUser.class).getById(new Long(id)).orElse(new PLUser());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public PLUser update(PLUser object) {
        return manager(PLUser.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(PLUser object) {
        manager(PLUser.class).delete(object);
    }
}

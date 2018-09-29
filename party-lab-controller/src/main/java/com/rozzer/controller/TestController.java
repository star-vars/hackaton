package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/developer")
public class TestController implements Controller<Test> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Test> getAll() {
        return manager(Test.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Test create() {
        return manager(Test.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Test read(String id) {
        return manager(Test.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(Test object) {
        manager(Test.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Test object) {
        manager(Test.class).delete(object);
    }
}

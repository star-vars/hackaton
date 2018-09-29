package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Theme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/theme")
public class ThemeController implements Controller<Theme> {


    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Theme> getAll() {
        return manager(Theme.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Theme create() {
        return manager(Theme.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Theme read(String id) {
        return manager(Theme.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(Theme object) {
        manager(Theme.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Theme object) {
        manager(Theme.class).delete(object);
    }
}

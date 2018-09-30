package com.rozzer.controller;

import com.rozzer.controller.common.EntityController;
import com.rozzer.model.Theme;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/theme")
public class ThemeController implements EntityController<Theme> {


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
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Theme read(@PathVariable String id) {
        return manager(Theme.class).getById(new Long(id)).orElse(new Theme());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Theme update(Theme object) {
        return manager(Theme.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Theme object) {
        manager(Theme.class).delete(object);
    }
}

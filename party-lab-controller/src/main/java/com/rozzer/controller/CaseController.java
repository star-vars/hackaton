package com.rozzer.controller;

import com.rozzer.controller.common.EntityController;
import com.rozzer.model.Case;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/api/developer")
public class CaseController implements EntityController<Case> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Case> getAll() {
        return manager(Case.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Case create() {
        return manager(Case.class).create();
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Case read(@PathVariable Long id) {
        return manager(Case.class).getById(id).orElse(new Case());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Case update(Case object) {
        return manager(Case.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Case object) {
        manager(Case.class).delete(object);
    }
}

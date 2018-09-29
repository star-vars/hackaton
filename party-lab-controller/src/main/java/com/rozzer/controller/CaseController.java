package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Case;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/developer")
public class CaseController implements Controller<Case> {

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
    @RequestMapping(method = RequestMethod.GET)
    public Optional<Case> read(String id) {
        return manager(Case.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(Case object) {
        manager(Case.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Case object) {
        manager(Case.class).delete(object);
    }
}

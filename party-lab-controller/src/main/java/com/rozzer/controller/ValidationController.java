package com.rozzer.controller;

import com.rozzer.model.UserProject;
import com.rozzer.validate.Report;
import com.rozzer.validate.Reporter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RequestMapping(value = "/api/validate")
@RestController
public class ValidationController {
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Report validate(@PathVariable String id) {
        Optional<UserProject> userProject = manager(UserProject.class).getById(new Long(id));
        UserProject project = userProject.orElseThrow(
                () -> new RuntimeException("User Project is not present"));
        return Reporter.getInstance().checkProject(project);
    }
}

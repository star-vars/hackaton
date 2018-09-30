package com.rozzer.controller;


import com.google.common.base.Strings;
import com.rozzer.controller.common.EntityController;
import com.rozzer.gh.ext.NewCommit;
import com.rozzer.gh.ext.service.UpdatebaleContentsService;
import com.rozzer.manager.ProjectManager;
import com.rozzer.model.PLUser;
import com.rozzer.model.Project;
import com.rozzer.model.ProjectStructure;
import com.rozzer.model.Theme;
import com.rozzer.service.ListResult;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.CommitUser;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.RequestException;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController implements EntityController<Project> {

    @Autowired
    private SessionData sessionData;

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> getAll() {
        return manager(Project.class).getAll();
    }

    @RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
    public ListResult<Project> getAllByPage(@PathVariable Integer page) {
        return ListResult.of(manager(Project.class).getAllByPage(EntityController.createPage(page, 4)), manager(Project.class).countAll());
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Project create() {
        return manager(Project.class).create();
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Project read(@PathVariable Long id) {
        return manager(Project.class).getById(id).orElse(new Project());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Project update(@RequestBody Project object) {
        try {
            object.setCustomer(sessionData.getUser());
            if (Strings.isNullOrEmpty(object.getRepo()) || Strings.isNullOrEmpty(object.getName())) {
                throw new RuntimeException("Illegal field data");
            }
            RepositoryService repositoryService = new RepositoryService(sessionData.getGhClient());
            Repository repository = null;
            try {
                repository = repositoryService.getRepository(sessionData.getUser().getLogin(), object.getRepo());
            } catch (RequestException ignored) {
            }
            if (repository == null) {
                repository = repositoryService.createRepository(new Repository().setName(object.getRepo()));
            }
            object.setRepoUrl(repository.getGitUrl());
//            UpdatebaleContentsService contentsService = new UpdatebaleContentsService(sessionData.getGhClient());
//            contentsService.createFile(repository,
//                    ProjectStructure.TEST_CASES_FOLDER + "/.gitkeep",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("".getBytes()))
//                            .setMessage("Auto-create test cases folder")
//                            .setCommitter(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
//            contentsService.createFile(repository,
//                    ProjectStructure.DESIGN_FOLDER + "/.gitkeep",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("".getBytes()))
//                            .setMessage("Auto-create design folder")
//                            .setCommitter(
//                                    new CommitUser().setName(sessionData.getUser().getLogin())
//                                            .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
//            contentsService.createFile(repository,
//                    ProjectStructure.ARCHITECTURE_FOLDER + "/.gitkeep",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("".getBytes()))
//                            .setMessage("Auto-create architecture folder")
//                            .setCommitter(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
//            contentsService.createFile(repository,
//                    ProjectStructure.SRC_MAIN_FOLDER + "/.gitkeep",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("".getBytes()))
//                            .setMessage("Auto-create sources folder")
//                            .setCommitter(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
//            contentsService.createFile(repository,
//                    ProjectStructure.SRC_TESTS_FOLDER + "/.gitkeep",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("".getBytes()))
//                            .setMessage("Auto-create autotests folder")
//                            .setCommitter(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
//            contentsService.createFile(repository, "README.md",
//                    new NewCommit()
//                            .setContent(Base64.getEncoder().encodeToString("This is readme file with sample task description".getBytes()))
//                            .setMessage("Auto-create readme folder")
//                            .setCommitter(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//                            .setAuthor(new CommitUser().setName(sessionData.getUser().getLogin())
//                                    .setEmail(sessionData.getUser().getMail()))
//            );
            return manager(Project.class).save(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Project object) {
        manager(Project.class).delete(object);
    }

    @GetMapping("/theme/{theme}")
    public List<Project> getProjectByThemes(@PathVariable String theme) {
        List<Theme> themeList = manager(Theme.class).getByName(theme);
        Theme aTheme = themeList.stream().findFirst().orElse(new Theme(theme));
        return manager(Project.class, ProjectManager.class).findByTheme(aTheme);
    }

    @GetMapping("/user{userId}")
    public List<Project> getProjectByCustomer(@RequestParam String userId) {
        PLUser plUser = manager(PLUser.class).getById(new Long(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found by id: " + userId));
        return manager(Project.class, ProjectManager.class).findByUser(plUser);
    }

}

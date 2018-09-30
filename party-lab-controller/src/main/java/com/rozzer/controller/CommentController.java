package com.rozzer.controller;

import com.rozzer.controller.common.EntityController;
import com.rozzer.manager.CommentManager;
import com.rozzer.model.Comment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping("/api/comment")
public class CommentController implements EntityController<Comment> {
    @Override
    @RequestMapping(value = "all")
    public List<Comment> getAll() {
        return manager(Comment.class).getAll();
    }

    @RequestMapping(value = "byProject/{projectId}")
    public List<Comment> getAllByProjectId(@PathVariable Long projectId) {
        return manager(Comment.class, CommentManager.class).getAllByProjectId(projectId);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Comment create() {
        return manager(Comment.class).create();
    }

    @Override
    @RequestMapping(value = "{id}")
    public Comment read(@PathVariable Long id) {
        return manager(Comment.class).getById(id).orElse(new Comment());
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Comment update(Comment object) {
        return manager(Comment.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Comment object) {
        manager(Comment.class).delete(object);
    }
}
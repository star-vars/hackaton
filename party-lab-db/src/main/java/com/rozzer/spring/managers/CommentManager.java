package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Comment;
import com.rozzer.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements Manager<Comment> {

    private CommentRepository repository;

    @Autowired
    public CommentManager(CommentRepository commentRepository) {
        this.repository = commentRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(Comment.class, this);
    }


    @Override
    public List<Comment> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public List<Comment> getAllByPage(int page){
        throw new NotImplementedException();
    }

    @Override
    public void save(Comment saved) {
        repository.save(saved);
    }

    @Override
    public void delete(Comment saved) {
        repository.delete(saved);
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Comment> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Comment create() {
        Comment comment = new Comment();
        repository.save(comment);
        return comment;
    }
}

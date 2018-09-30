package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CommentManager;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Comment;
import com.rozzer.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManagerImpl implements CommentManager {

    private CommentRepository repository;

    @Autowired
    public CommentManagerImpl(CommentRepository commentRepository) {
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
    public List<Comment> getAllByPage(Pageable page){
        throw new NotImplementedException();
    }

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public Comment save(Comment saved) {
        return repository.save(saved);
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

    @Override
    public List<Comment> getAllByProjectId(Long projectId) {
        return repository.findAllByProject_Id(projectId);
    }
}

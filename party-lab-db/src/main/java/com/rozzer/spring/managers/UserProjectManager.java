package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.UserProject;
import com.rozzer.spring.repositories.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProjectManager implements Manager<UserProject> {

    private UserProjectRepository repository;

    @Autowired
    public UserProjectManager(UserProjectRepository projectRepository) {
        this.repository = projectRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(UserProject.class, this);
    }


    @Override
    public List<UserProject> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(UserProject saved) {
        repository.save(saved);
    }

    @Override
    public void delete(UserProject saved) {
        repository.delete(saved);
    }

    @Override
    public Optional<UserProject> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserProject create() {
        UserProject project = new UserProject();
        repository.save(project);
        return project;
    }

}

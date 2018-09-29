package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Project;
import com.rozzer.spring.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManager implements Manager<Project> {

    private ProjectRepository repository;

    @Autowired
    public ProjectManager(ProjectRepository projectRepository) {
        this.repository = projectRepository;
        init();
    }

    private void init() {
        this.repository.save(new Project("Jack"));
        this.repository.save(new Project("Chloe"));
        this.repository.save(new Project("Kim"));
        this.repository.save(new Project("David"));
        this.repository.save(new Project("Michelle"));
        CoreObjectManager.getManagerFactory().register(Project.class, this);
    }


    @Override
    public List<Project> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(Project saved) {
        repository.save(saved);
    }

    @Override
    public void delete(Project saved) {
        repository.delete(saved);
    }

    @Override
    public Project getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Project create() {
        Project project = new Project();
        repository.save(project);
        return project;
    }
}

package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.ProjectManager;
import com.rozzer.model.PLUser;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;
import com.rozzer.spring.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectManagerImpl implements ProjectManager {

    private ProjectRepository repository;

    @Autowired
    public ProjectManagerImpl(ProjectRepository projectRepository) {
        this.repository = projectRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(Project.class, this);
    }


    @Override
    public List<Project> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public List<Project> getAllByPage(int page){
        return Lists.newArrayList(repository.findAll(new PageRequest(page, 4)));
    }

    @Override
    public Project save(Project saved) {
        return repository.save(saved);
    }

    @Override
    public void delete(Project saved) {
        repository.delete(saved);
    }

    @Override
    public Optional<Project> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Project> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Project create() {
        Project project = new Project();
        repository.save(project);
        return project;
    }

    @Override
    public List<Project> findByTheme(Theme theme) {
        return repository.findAllByThemes(theme);
    }

    @Override
    public List<Project> findByUser(PLUser user) {
        return repository.findAllByCustomer(user);
    }
}

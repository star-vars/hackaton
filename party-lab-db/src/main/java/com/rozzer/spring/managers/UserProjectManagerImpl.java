package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.common.WorkStatus;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.UserProjectManager;
import com.rozzer.model.PLUser;
import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import com.rozzer.spring.repositories.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProjectManagerImpl implements UserProjectManager {

    private UserProjectRepository repository;

    @Autowired
    public UserProjectManagerImpl(UserProjectRepository projectRepository) {
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

    public List<UserProject> getAllByPage(Pageable page){
        return Lists.newArrayList(repository.findAll(page));
    }

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public UserProject save(UserProject saved) {
        return repository.save(saved);
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
    public List<UserProject> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public UserProject create() {
        UserProject project = new UserProject();
        repository.save(project);
        return project;
    }

    @Override
    public List<UserProject> findByUserAndStatus(PLUser user, WorkStatus status) {
        return repository.findByUserAndStatus(user, status);
    }

    @Override
    public List<UserProject> findByUser(PLUser user) {
        return repository.findByUser(user);
    }

    @Override
    public List<UserProject> findByTheme(Theme theme) {
        return repository.findAllByProject_Themes(theme);
    }

    @Override
    public List<UserProject> findByProjectId(Long projectId) {
        return repository.findAllByProject_Id(projectId);
    }
}

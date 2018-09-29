package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Theme;
import com.rozzer.spring.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeManager implements Manager<Theme> {

    private ThemeRepository repository;

    @Autowired
    public ThemeManager(ThemeRepository themeRepository) {
        this.repository = themeRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(Theme.class, this);
    }


    @Override
    public List<Theme> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(Theme saved) {
        repository.save(saved);
    }

    @Override
    public void delete(Theme saved) {
        repository.delete(saved);
    }

    @Override
    public Optional<Theme> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Theme create() {
        Theme theme = new Theme();
        repository.save(theme);
        return theme;
    }
}

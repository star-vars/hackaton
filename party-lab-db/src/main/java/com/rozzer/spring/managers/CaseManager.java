package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Case;
import com.rozzer.spring.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseManager implements Manager<Case> {

    private CaseRepository repository;

    @Autowired
    public CaseManager(CaseRepository testRepository) {
        this.repository = testRepository;
        init();
    }

    private void init() {
        this.repository.save(new Case("Jack"));
        this.repository.save(new Case("Chloe"));
        this.repository.save(new Case("Kim"));
        this.repository.save(new Case("David"));
        this.repository.save(new Case("Michelle"));
        CoreObjectManager.getManagerFactory().register(Case.class, this);
    }


    @Override
    public List<Case> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(Case saved) {
        repository.save(saved);
    }

    @Override
    public void delete(Case saved) {
        repository.delete(saved);
    }

    @Override
    public Case getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Case create() {
        Case test = new Case();
        repository.save(test);
        return test;
    }
}

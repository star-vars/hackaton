package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Case;
import com.rozzer.spring.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class CaseManager implements Manager<Case> {

    private CaseRepository repository;

    @Autowired
    public CaseManager(CaseRepository testRepository) {
        this.repository = testRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(Case.class, this);
    }


    @Override
    public List<Case> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public List<Case> getAllByPage(Pageable page){
        throw new NotImplementedException();
    }

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public Case save(Case saved) {
        return repository.save(saved);
    }

    @Override
    public void delete(Case saved) {
        repository.delete(saved);
    }

    @Override
    public Optional<Case> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Case> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Case create() {
        Case test = new Case();
        repository.save(test);
        return test;
    }
}

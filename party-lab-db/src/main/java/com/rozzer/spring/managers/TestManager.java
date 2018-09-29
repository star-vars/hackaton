package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Test;
import com.rozzer.spring.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestManager implements Manager<Test> {

    private TestRepository repository;

    @Autowired
    public TestManager(TestRepository testRepository) {
        this.repository = testRepository;
        init();
    }

    private void init() {
        this.repository.save(new Test("Jack"));
        this.repository.save(new Test("Chloe"));
        this.repository.save(new Test("Kim"));
        this.repository.save(new Test("David"));
        this.repository.save(new Test("Michelle"));
        CoreObjectManager.getManagerFactory().register(Test.class, this);
    }


    @Override
    public List<Test> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(Test saved) {
        repository.save(saved);
    }

    @Override
    public void delete(Test saved) {
        repository.delete(saved);
    }

    @Override
    public Test getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Test create() {
        Test test = new Test();
        repository.save(test);
        return test;
    }
}

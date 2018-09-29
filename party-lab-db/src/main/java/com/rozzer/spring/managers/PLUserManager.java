package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.PLUser;
import com.rozzer.spring.repositories.PLUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PLUserManager implements Manager<PLUser> {

    private PLUserRepository repository;

    @Autowired
    public PLUserManager(PLUserRepository developerRepository) {
        this.repository = developerRepository;
        init();
    }

    private void init() {
        this.repository.save(new PLUser("Jack"));
        this.repository.save(new PLUser("Chloe"));
        this.repository.save(new PLUser("Kim"));
        this.repository.save(new PLUser("David"));
        this.repository.save(new PLUser("Michelle"));
        CoreObjectManager.getManagerFactory().register(PLUser.class, this);
    }


    @Override
    public List<PLUser> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(PLUser saved) {
        repository.save(saved);
    }

    @Override
    public void delete(PLUser saved) {
        repository.delete(saved);
    }

    @Override
    public PLUser getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public PLUser create() {
        PLUser developer = new PLUser();
        repository.save(developer);
        return developer;
    }
}

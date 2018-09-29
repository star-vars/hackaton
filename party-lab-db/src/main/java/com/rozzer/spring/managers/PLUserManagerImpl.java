package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.PLUserManager;
import com.rozzer.model.PLUser;
import com.rozzer.spring.repositories.PLUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PLUserManagerImpl implements PLUserManager {

    private PLUserRepository repository;

    @Autowired
    public PLUserManagerImpl(PLUserRepository developerRepository) {
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
        return repository.findById(id).orElse(null);
    }

    @Override
    public PLUser create() {
        PLUser developer = new PLUser();
        repository.save(developer);
        return developer;
    }

    @Override
    public PLUser getByNameAndEmail(String name, String email) {
        return repository.getPLUserByNameAndMail(name, email);
    }
}
package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.User;
import com.rozzer.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements Manager<User> {

    private UserRepository repository;

    @Autowired
    public UserManager(UserRepository developerRepository) {
        this.repository = developerRepository;
        init();
    }

    private void init() {
        this.repository.save(new User("Jack"));
        this.repository.save(new User("Chloe"));
        this.repository.save(new User("Kim"));
        this.repository.save(new User("David"));
        this.repository.save(new User("Michelle"));
        CoreObjectManager.getManagerFactory().register(User.class, this);
    }


    @Override
    public List<User> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void save(User saved) {
        repository.save(saved);
    }

    @Override
    public void delete(User saved) {
        repository.delete(saved);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User create() {
        User developer = new User();
        repository.save(developer);
        return developer;
    }
}

package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.PLUserManager;
import com.rozzer.model.PLUser;
import com.rozzer.spring.repositories.PLUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class PLUserManagerImpl implements PLUserManager {

    private PLUserRepository repository;

    @Autowired
    public PLUserManagerImpl(PLUserRepository developerRepository) {
        this.repository = developerRepository;
        init();
    }

    private void init() {
        CoreObjectManager.getManagerFactory().register(PLUser.class, this);
    }


    @Override
    public List<PLUser> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public List<PLUser> getAllByPage(int page){
        throw new NotImplementedException();
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
    public Optional<PLUser> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PLUser> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public PLUser create() {
        PLUser developer = new PLUser();
        repository.save(developer);
        return developer;
    }

    @Override
    public Optional<PLUser> getByLogin(String login) {
        return repository.getPLUserByLogin(login);
    }
}

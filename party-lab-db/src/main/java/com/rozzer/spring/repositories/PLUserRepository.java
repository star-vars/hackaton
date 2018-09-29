package com.rozzer.spring.repositories;

import com.rozzer.model.PLUser;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PLUserRepository extends CrudRepository<PLUser, Long> {
    Optional<PLUser> getPLUserByLogin(String login);
    List<PLUser> findAllByName(String name);
}

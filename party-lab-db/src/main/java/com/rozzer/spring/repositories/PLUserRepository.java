package com.rozzer.spring.repositories;

import com.rozzer.model.PLUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PLUserRepository extends CrudRepository<PLUser, Long> {
    Optional<PLUser> getPLUserByNameAndMail(String name, String email);
}

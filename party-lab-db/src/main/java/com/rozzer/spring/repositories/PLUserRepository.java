package com.rozzer.spring.repositories;

import com.rozzer.model.PLUser;
import org.springframework.data.repository.CrudRepository;

public interface PLUserRepository extends CrudRepository<PLUser, Long> {
    PLUser getPLUserByNameAndMail(String name, String email);
}

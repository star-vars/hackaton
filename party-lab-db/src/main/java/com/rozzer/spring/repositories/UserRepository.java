package com.rozzer.spring.repositories;

import com.rozzer.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

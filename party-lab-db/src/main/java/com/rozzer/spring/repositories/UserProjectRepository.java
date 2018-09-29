package com.rozzer.spring.repositories;

import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

public interface UserProjectRepository extends CrudRepository<UserProject, Long> {
}

package com.rozzer.spring.repositories;

import com.rozzer.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}

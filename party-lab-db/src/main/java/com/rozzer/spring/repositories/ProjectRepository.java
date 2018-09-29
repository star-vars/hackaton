package com.rozzer.spring.repositories;

import com.rozzer.model.Project;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAllByName(String name);

}

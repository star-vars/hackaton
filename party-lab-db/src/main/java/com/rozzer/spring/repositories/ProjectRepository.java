package com.rozzer.spring.repositories;

import com.rozzer.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    List<Project> findAllByName(String name);

}

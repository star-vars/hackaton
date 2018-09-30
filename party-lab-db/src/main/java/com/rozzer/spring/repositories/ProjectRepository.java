package com.rozzer.spring.repositories;

import com.rozzer.model.PLUser;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    List<Project> findAllByName(String name);
    List<Project> findAllByThemes(Theme theme);
    List<Project> findAllByCustomer(PLUser theme);


}

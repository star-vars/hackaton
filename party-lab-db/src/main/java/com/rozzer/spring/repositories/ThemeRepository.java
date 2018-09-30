package com.rozzer.spring.repositories;

import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ThemeRepository extends PagingAndSortingRepository<Theme, Long> {

    List<Theme> findAllByName(String name);

}

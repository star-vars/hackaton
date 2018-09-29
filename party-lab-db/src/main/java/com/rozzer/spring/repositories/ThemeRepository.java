package com.rozzer.spring.repositories;

import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemeRepository extends CrudRepository<Theme, Long> {

    List<Theme> findAllByName(String name);

}

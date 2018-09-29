package com.rozzer.spring.repositories;

import com.rozzer.model.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Long> {
}

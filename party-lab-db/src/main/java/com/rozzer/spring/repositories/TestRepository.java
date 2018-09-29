package com.rozzer.spring.repositories;

import com.rozzer.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}

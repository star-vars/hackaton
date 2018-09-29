package com.rozzer.spring.repositories;

import com.rozzer.model.Case;
import org.springframework.data.repository.CrudRepository;

public interface CaseRepository extends CrudRepository<Case, Long> {
}

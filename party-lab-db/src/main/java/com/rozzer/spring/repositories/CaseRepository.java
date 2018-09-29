package com.rozzer.spring.repositories;

import com.rozzer.model.Case;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaseRepository extends CrudRepository<Case, Long> {

    List<Case> findAllByName(String name);

}

package com.rozzer.spring.repositories;

import com.rozzer.model.Case;
import com.rozzer.model.UserProject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CaseRepository extends PagingAndSortingRepository<Case, Long> {

    List<Case> findAllByName(String name);

}

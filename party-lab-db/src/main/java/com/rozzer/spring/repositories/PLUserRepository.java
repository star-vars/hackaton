package com.rozzer.spring.repositories;

import com.rozzer.model.Case;
import com.rozzer.model.PLUser;
import com.rozzer.model.UserProject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PLUserRepository extends PagingAndSortingRepository<PLUser, Long> {
    Optional<PLUser> getPLUserByLogin(String login);
    List<PLUser> findAllByName(String name);
}

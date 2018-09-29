package com.rozzer.spring.repositories;

import com.rozzer.model.PLUser;
import com.rozzer.model.UserProject;
import com.rozzer.model.WorkStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserProjectRepository extends CrudRepository<UserProject, Long> {

    List<UserProject> findByUserAndStatus(PLUser user, WorkStatus status);

}

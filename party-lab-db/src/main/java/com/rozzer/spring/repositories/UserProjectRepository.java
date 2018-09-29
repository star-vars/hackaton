package com.rozzer.spring.repositories;

import com.rozzer.common.WorkStatus;
import com.rozzer.model.PLUser;
import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserProjectRepository extends PagingAndSortingRepository<UserProject, Long> {

    List<UserProject> findByUserAndStatus(PLUser user, WorkStatus status);
    List<UserProject> findByUser(PLUser user);
    List<UserProject> findAllByName(String name);
    List<UserProject> findAllByProject_Themes(Theme theme);

}

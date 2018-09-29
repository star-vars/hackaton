package com.rozzer.manager;

import com.rozzer.model.PLUser;
import com.rozzer.model.UserProject;
import com.rozzer.model.WorkStatus;

import java.util.List;

public interface UserProjectManager extends Manager<UserProject> {

    List<UserProject> findByUserAndStatus(PLUser user, WorkStatus status);

}

package com.rozzer.manager;

import com.rozzer.common.WorkStatus;
import com.rozzer.model.PLUser;
import com.rozzer.model.Theme;
import com.rozzer.model.UserProject;

import java.util.List;

public interface UserProjectManager extends Manager<UserProject> {

    List<UserProject> findByUserAndStatus(PLUser user, WorkStatus status);
    List<UserProject> findByUser(PLUser user);
    List<UserProject> findByTheme(Theme theme);

}

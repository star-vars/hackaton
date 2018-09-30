package com.rozzer.manager;

import com.rozzer.model.PLUser;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;

import java.util.List;

public interface ProjectManager  extends Manager<Project> {
    List<Project> findByTheme(Theme theme);
    List<Project> findByUser(PLUser user);

}

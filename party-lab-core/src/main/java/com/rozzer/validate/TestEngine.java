package com.rozzer.validate;

import com.rozzer.model.UserProject;

public interface TestEngine {
    Report checkProject(UserProject userProject);
}

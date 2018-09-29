package com.rozzer.manager;

import com.rozzer.model.PLUser;

public interface PLUserManager extends Manager<PLUser> {
    PLUser getByNameAndEmail(String login, String name);
}

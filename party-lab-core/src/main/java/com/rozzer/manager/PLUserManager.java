package com.rozzer.manager;

import com.rozzer.model.PLUser;

import java.util.Optional;

public interface PLUserManager extends Manager<PLUser> {
    Optional<PLUser> getByLogin(String login);
}

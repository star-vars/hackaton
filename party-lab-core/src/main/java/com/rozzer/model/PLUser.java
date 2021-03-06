package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.common.Role;

import javax.persistence.Entity;

@Entity(name = "pl_users")
public class PLUser extends AbstractSaved {

    private String mail;
    private Role role;
    private String login;
    private String avatarUrl;

    public PLUser() {
    }

    public PLUser(String name) {
        super(name);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}

package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity(name = "user_projects")
public class UserProject extends AbstractSaved {

    @ManyToMany
    private PLUser user;
    @ManyToMany
    private Project project;

    private String repo;

    public UserProject() {
    }

    public UserProject(String name) {
        super(name);
    }

    public PLUser getUser() {
        return user;
    }

    public void setUser(PLUser user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    @Override
    public void save() {

    }

}

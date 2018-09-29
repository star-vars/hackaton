package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "user_projects")
public class UserProject extends AbstractSaved {

    @OneToOne
    @JoinColumn(name="user_id")
    private PLUser user;
    @OneToOne
    @JoinColumn(name="project_id")
    private Project project;

    private String repo;
    private String repoUrl;
    private WorkStatus status;

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

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    @Override
    public void save() {

    }

    public WorkStatus getStatus() {
        return status;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }
}

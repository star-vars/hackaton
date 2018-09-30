package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.common.WorkStatus;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.List;

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

    @Transient
    private List<Case> userCases;

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

    public WorkStatus getStatus() {
        return status;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    public List<Case> getUserCases() {
        return userCases;
    }

    public void setUserCases(List<Case> userCases) {
        this.userCases = userCases;
    }
}

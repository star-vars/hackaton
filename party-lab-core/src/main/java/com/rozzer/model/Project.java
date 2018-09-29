package com.rozzer.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rozzer.common.AbstractSaved;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "projects")
public class Project extends AbstractSaved {

    @OneToMany
    private List<Case> cases = Lists.newArrayList();
    @OneToMany
    private List<Comment> comments = Lists.newArrayList();
    @OneToMany
    private Set<Theme> themes = Sets.newHashSet();
    @OneToOne
    private PLUser customer;

    public Project() {
        super();
    }

    public Project(String name) {
        super(name);
    }

    @Override
    public void save() {

    }


    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }
}

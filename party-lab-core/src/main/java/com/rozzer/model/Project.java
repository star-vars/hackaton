package com.rozzer.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @ManyToOne
    @JoinColumn(name="customer_id")
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

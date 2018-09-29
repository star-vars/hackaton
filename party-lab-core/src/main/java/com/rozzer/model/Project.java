package com.rozzer.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
public class Project extends AbstractSaved {
    private List<Case> cases = Lists.newArrayList();
    private List<Comment> comments = Lists.newArrayList();
    private Set<Theme> themes = Sets.newHashSet();
    private PLUser customer;

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

package com.rozzer.model;

import com.google.common.collect.Lists;
import com.rozzer.common.AbstractSaved;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Project extends AbstractSaved {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private List<Case> cases = Lists.newArrayList();
    private List<Comment> comments = Lists.newArrayList();
    private List<Theme> themes = Lists.newArrayList();
    private User customer;



    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    @Override
    public void save() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(@Nonnull Long id) {
        this.id = id;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(@Nonnull String name) {
        this.name = name;
    }
}

package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;


@Entity(name = "themes")
public class Theme extends AbstractSaved {


    private String description;

    public Theme() {
    }

    public Theme(String name) {
        super(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

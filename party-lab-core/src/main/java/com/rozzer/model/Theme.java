package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;


@Entity(name = "themes")
public class Theme extends AbstractSaved {


    private String description;

    @Override
    public void save() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

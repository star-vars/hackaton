package com.rozzer.common;

import com.rozzer.model.Theme;

import javax.annotation.Nonnull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractSaved implements Saved {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public AbstractSaved() {
    }

    public AbstractSaved(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(@Nonnull Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(@Nonnull String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Theme) {
            return Objects.equals(((Theme) obj).getId(), this.getId());
        } else {
            return false;
        }
    }
}

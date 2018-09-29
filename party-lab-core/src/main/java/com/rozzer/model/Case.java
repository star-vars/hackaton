package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import org.json.simple.JSONObject;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Case extends AbstractSaved {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private JSONObject caseBody;

    public Case() {
    }

    public Case(String name) {
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

    public JSONObject getCaseBody() {
        return caseBody;
    }

    public void setCaseBody(JSONObject caseBody) {
        this.caseBody = caseBody;
    }
}

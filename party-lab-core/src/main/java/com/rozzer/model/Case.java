package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.common.CaseType;
import org.json.simple.JSONObject;

import javax.persistence.Entity;

@Entity(name = "cases")
public class Case extends AbstractSaved {

    private CaseType type;
    private String description;
    private String body;
    private String fileName;

    public Case() {
    }

    public Case(String name) {
        super(name);
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

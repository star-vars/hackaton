package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.common.Type;
import org.json.simple.JSONObject;

import javax.persistence.Entity;

@Entity(name = "cases")
public class Case extends AbstractSaved {

    private Type type;
    private JSONObject caseBody;

    public Case() {
    }

    public Case(String name) {
        super(name);
    }

    @Override
    public void save() {

    }

    public JSONObject getCaseBody() {
        return caseBody;
    }

    public void setCaseBody(JSONObject caseBody) {
        this.caseBody = caseBody;
    }
}

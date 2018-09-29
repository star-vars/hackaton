package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.common.CaseType;
import org.json.simple.JSONObject;

import javax.persistence.Entity;

@Entity(name = "cases")
public class Case extends AbstractSaved {

    private CaseType type;
    private JSONObject caseBody;

    public Case() {
    }

    public Case(String name) {
        super(name);
    }

    public JSONObject getCaseBody() {
        return caseBody;
    }

    public void setCaseBody(JSONObject caseBody) {
        this.caseBody = caseBody;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }
}

package com.rozzer.validate;

import com.google.common.collect.Lists;
import com.rozzer.model.Case;
//import javafx.util.Pair;

import java.util.List;

public class Report {

    private List<Pair<Status, Case>>  report = Lists.newArrayList();

    public void addCase(Status status, Case aCase){
        report.add(new Pair<>(status, aCase));
    }

    public List<Pair<Status, Case>> getReport() {
        return report;
    }
}

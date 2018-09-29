package com.rozzer.checks.result;

import com.google.common.collect.Lists;

import java.util.Collection;

public class ComplexCheckResult implements CheckResult {

    private int capacity;
    private Collection<CheckResult> results;

    public ComplexCheckResult(int capacity) {
        this.capacity = capacity;
        results = Lists.newArrayListWithCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public ComplexCheckResult setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Collection<CheckResult> getResults() {
        return results;
    }

    public ComplexCheckResult setResults(Collection<CheckResult> results) {
        this.results = results;
        return this;
    }

    @Override
    public int getWeight() {
        if (capacity > results.size()) {
            return 1;
        } else {
            return results.stream().max(CheckResult::compareTo).orElse(SimpleCheckResult.PASSED).getWeight();
        }
    }

}

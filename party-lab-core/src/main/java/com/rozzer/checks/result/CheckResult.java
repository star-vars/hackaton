package com.rozzer.checks.result;

public interface CheckResult extends Comparable<CheckResult> {

    int getWeight();

    @Override
    default int compareTo(CheckResult o) {
        return Integer.compare(getWeight(), o.getWeight());
    }
}

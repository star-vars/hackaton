package com.rozzer.checks.result;

public class SimpleCheckResult implements CheckResult {

    public static SimpleCheckResult FAILED = new SimpleCheckResult(2);
    public static SimpleCheckResult WARN = new SimpleCheckResult(1);
    public static SimpleCheckResult PASSED = new SimpleCheckResult(0) ;

    private int weight;

    private SimpleCheckResult(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}

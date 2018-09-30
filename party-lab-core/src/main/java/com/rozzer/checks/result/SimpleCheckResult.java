package com.rozzer.checks.result;

public class SimpleCheckResult implements CheckResult {

    public static SimpleCheckResult FAILED = new SimpleCheckResult(2, "Failed");
    public static SimpleCheckResult WARN = new SimpleCheckResult(1, "Warning");
    public static SimpleCheckResult PASSED = new SimpleCheckResult(0, "Passed") ;

    private int weight;
    private String name;

    private SimpleCheckResult(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

}

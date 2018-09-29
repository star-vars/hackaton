package com.rozzer.common;

public enum Type {
    UNIT_TEST("unit_test"), USE_CASE("use_case"), CODE_STYLE("code_style");

    private String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                '}';
    }
}

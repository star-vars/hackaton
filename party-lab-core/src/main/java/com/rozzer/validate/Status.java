package com.rozzer.validate;

public enum Status {
    SUCCESS("Success"), ERROR("Error");

    private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }
}

package com.rozzer.common;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}

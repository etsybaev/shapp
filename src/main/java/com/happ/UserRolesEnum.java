package com.happ;

/**
 * Created by oleksandr.agafonov on 30-Nov-16.
 */
public enum UserRolesEnum {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");


    private final String role;

    UserRolesEnum(String role) {
        this.role=role;
    }

    public String getRole() {
        return role;
    }
}

package com.example.bankapppro.entity;

import lombok.Getter;

@Getter
public enum Permission {

    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
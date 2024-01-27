package com.github.gustavoflor.dpho.creational.builder.user;

import java.util.Collection;

public class User {

    private final String name;
    private final String email;
    private final String phone;
    private final int age;
    private final Collection<String> permissions;

    protected User(final String name,
                   final String email,
                   final String phone,
                   final int age,
                   final Collection<String> permissions) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }
}

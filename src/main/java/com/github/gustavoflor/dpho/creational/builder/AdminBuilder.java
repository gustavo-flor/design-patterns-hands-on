package com.github.gustavoflor.dpho.creational.builder;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class AdminBuilder implements UserBuilder {

    private String name;
    private String email;
    private String phone;
    private Integer age;

    @Override
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
        if (!email.endsWith("@admin.com")) {
            throw new IllegalArgumentException();
        }
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public UserBuilder setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException();
        }
        this.age = age;
        return this;
    }

    @Override
    public User build() {
        if (isNull(name) || isNull(email) || isNull(phone) || isNull(age)) {
            throw new IllegalArgumentException();
        }
        final var permissions = new ArrayList<String>();
        permissions.add("users.read");
        permissions.add("users.update");
        permissions.add("users.delete");
        permissions.add("users.upgrade");
        return new User(name, email, phone, age, permissions);
    }

}

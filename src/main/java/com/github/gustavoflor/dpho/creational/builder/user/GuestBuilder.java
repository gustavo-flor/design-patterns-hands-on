package com.github.gustavoflor.dpho.creational.builder.user;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.isNull;

public class GuestBuilder implements UserBuilder {

    private String name;
    private String email;
    private String phone;
    private Integer age;
    private final Collection<String> permissions = new ArrayList<>();

    @Override
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
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
        if (age < 10) {
            throw new IllegalArgumentException();
        }
        if (age < 18) {
            permissions.add("underage");
        }
        this.age = age;
        return this;
    }

    @Override
    public User build() {
        if (isNull(name) || isNull(email) || isNull(age)) {
            throw new IllegalArgumentException();
        }
        return new User(name, email, phone, age, permissions);
    }

}

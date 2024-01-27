package com.github.gustavoflor.dpho.creational.builder.user;

public interface UserBuilder {

    UserBuilder setName(String name);

    UserBuilder setEmail(String email);

    UserBuilder setPhone(String phone);

    UserBuilder setAge(int age);

    User build();

}

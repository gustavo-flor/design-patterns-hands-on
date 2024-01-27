package com.github.gustavoflor.dpho.creational.builder;

public class UserDirector {

    public UserBuilder adminBuilder() {
        return new AdminBuilder();
    }

    public UserBuilder guestBuilder() {
        return new GuestBuilder();
    }
}

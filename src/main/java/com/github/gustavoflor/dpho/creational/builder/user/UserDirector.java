package com.github.gustavoflor.dpho.creational.builder.user;

public class UserDirector {

    public UserBuilder adminBuilder() {
        return new AdminBuilder();
    }

    public UserBuilder guestBuilder() {
        return new GuestBuilder();
    }
}

package com.github.gustavoflor.dpho.structural.bridge;

public class UserService {

    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void create(User user) {
        // do user creation...
        notificationService.notify("Welcome...", user);
    }

}

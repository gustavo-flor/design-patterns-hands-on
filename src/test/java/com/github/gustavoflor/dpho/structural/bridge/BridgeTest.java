package com.github.gustavoflor.dpho.structural.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class BridgeTest {

    @Mock
    private SmsNotificationService smsNotificationService;

    @Mock
    private EmailNotificationService emailNotificationService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("""
        GIVEN a SMS notification service
        WHEN create user
        THEN should notify user by SMS
        """)
    void givenASMSNotificationServiceWhenCreateUserThenShouldNotifyUserBySMS() {
        final var user = new User("Gustavo Flôr");
        final var userService = new UserService(smsNotificationService);

        userService.create(user);

        verify(smsNotificationService).notify("Welcome...", user);
    }

    @Test
    @DisplayName("""
        GIVEN an e-mail notification service
        WHEN create user
        THEN should notify user by e-mail
        """)
    void givenAnEmailNotificationServiceWhenCreateUserThenShouldNotifyUserByEmail() {
        final var user = new User("Gustavo Flôr");
        final var userService = new UserService(emailNotificationService);

        userService.create(user);

        verify(emailNotificationService).notify("Welcome...", user);
    }

}

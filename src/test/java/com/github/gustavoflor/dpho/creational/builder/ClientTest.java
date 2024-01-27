package com.github.gustavoflor.dpho.creational.builder;

import com.github.gustavoflor.dpho.creational.builder.user.UserDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClientTest {

    private UserDirector userDirector;

    @BeforeEach
    void beforeEach() {
        userDirector = new UserDirector();
    }

    @Test
    @DisplayName("""
        GIVEN a valid user
        WHEN get admin builder and build object
        THEN should give the right permissions
        """)
    void givenAValidUserWhenGetAdminBuilderAndBuildObjectThenShouldGiveTheRightPermissions() {
        final var adminPermissions = List.of(
            "users.delete", "users.upgrade", "users.update", "users.read"
        );
        final var admin = userDirector.adminBuilder()
            .setName("Gustavo Flôr")
            .setName("Luccas Carlos")
            .setEmail("luccas.carlos@admin.com")
            .setPhone("+55 (99) 99999-9999")
            .setAge(22)
            .build();

        assertThat(admin.getName()).isEqualTo("Luccas Carlos");
        assertThat(admin.getAge()).isEqualTo(22);
        assertThat(admin.getEmail()).isEqualTo("luccas.carlos@admin.com");
        assertThat(admin.getPhone()).isEqualTo("+55 (99) 99999-9999");
        assertThat(admin.getPermissions()).matches(it -> it.containsAll(adminPermissions));
    }

    @Test
    @DisplayName("""
        GIVEN an underage user
        WHEN get guest admin user and build object
        THEN should give the right permissions
        """)
    void givenAnUnderageUserWhenGetGuestAdminUserAndBuildObjectThenShouldGiveTheRightPermissions() {
        final var underageRestriction = List.of("underage");
        final var guest = userDirector.guestBuilder()
            .setName("Diego Alves")
            .setEmail("diego.alves@test.com")
            .setAge(16)
            .build();

        assertThat(guest.getName()).isEqualTo("Diego Alves");
        assertThat(guest.getAge()).isEqualTo(16);
        assertThat(guest.getEmail()).isEqualTo("diego.alves@test.com");
        assertThat(guest.getPhone()).isNull();
        assertThat(guest.getPermissions()).matches(it -> it.containsAll(underageRestriction));
    }

}

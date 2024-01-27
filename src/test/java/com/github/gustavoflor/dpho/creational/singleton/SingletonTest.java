package com.github.gustavoflor.dpho.creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    @DisplayName("""
        GIVEN a singleton
        WHEN get two instances
        THEN should return same instance
        """)
    void givenASingletonWhenGetTwoInstancesThenShouldReturnSameInstance() {
        final var singleton = Singleton.getInstance();
        final var otherSingleton = Singleton.getInstance();

        assertThat(singleton).isEqualTo(otherSingleton);
        assertThat(singleton.getCreatedAt()).isEqualTo(otherSingleton.getCreatedAt());
    }

}

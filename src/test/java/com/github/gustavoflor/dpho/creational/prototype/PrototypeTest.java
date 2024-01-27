package com.github.gustavoflor.dpho.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrototypeTest {

    @Test
    @DisplayName("""
        GIVEN a repo
        WHEN get clone
        THEN should be the same object but not the same instance
        """)
    void givenARepoWhenGetCloneThenShouldBeTheSameObjectButNotTheSameInstance() {
        final var repo = new Repo("design-patterns-hands-on", true);

        final var fork = repo.getClone();

        assertThat(fork.equals(repo)).isTrue();
        assertThat(fork == repo).isFalse();
    }

}

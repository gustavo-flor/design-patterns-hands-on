package com.github.gustavoflor.dpho.structural.composite;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompositeTest {

    @Test
    void givenWhenThen() {
        final var box = new Box(List.of(new Item(), new Item())); // 6
        final var smallBox = new Box(List.of(new Item())); // 3
        final var bigBox = new Box(List.of(box, new Item(), smallBox)); // 21

        final var price = bigBox.getPrice();

        assertThat(price).isEqualTo(21f);
    }

}

package com.github.gustavoflor.dpho.structural.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AdapterTest {

    @Test
    @DisplayName("""
        GIVEN a calculator adapter
        WHEN sum
        THEN should return right result
        """)
    void givenACalculatorAdapterWhenSumThenShouldReturnRightResult() {
            final var calculator = new CalculatorAdapter();

            final var result = calculator.sum(2, 3);

            assertThat(result).isEqualTo(5);
    }

}

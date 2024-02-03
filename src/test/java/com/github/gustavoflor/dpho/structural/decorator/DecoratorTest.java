package com.github.gustavoflor.dpho.structural.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DecoratorTest {

    @Mock
    private Person person;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("""
        GIVEN a polite person
        WHEN say hi
        THEN should ask how you are
        """)
    void givenAPolitePersonWhenSayHiThenShouldAskHowYouAre() {
        final var politePerson = new PolitePerson(person);

        politePerson.sayHi();

        verify(person).sayHi();
        verify(person).say("How are you?");
    }

}

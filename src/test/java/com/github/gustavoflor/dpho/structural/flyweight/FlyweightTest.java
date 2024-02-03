package com.github.gustavoflor.dpho.structural.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FlyweightTest {

    @Spy
    private TreeFactory treeFactory;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("""
        GIVEN a forest
        WHEN add a tree
        THEN should not instantiate 4 tree types
        """)
    void givenAForestWhenAddATreeThenShouldNotInstantiateFourTreeTypes() {
        final var forest = new Forest(treeFactory);

        forest.addTree(0, 3, "Redwood", "Red");
        forest.addTree(5, 0, "Tupi", "Soft-Brown");
        forest.addTree(10, -2, "Redwood", "Red");
        forest.addTree(7, 34, "Tupi", "Brown");
        forest.point();

        assertThat(forest.getTreesSize()).isEqualTo(4);
        assertThat(treeFactory.getTreeTypesSize()).isEqualTo(3);
        verify(treeFactory, times(4)).getTreeType(anyString(), anyString());
    }

}

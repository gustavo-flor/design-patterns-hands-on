package com.github.gustavoflor.dpho.creational.abstractfactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {

    private FurnitureFactory furnitureFactory;

    @Test
    @DisplayName("""
        GIVEN a classic furniture factory
        WHEN create furniture
        THEN should get classic type
        """)
    void givenAClassicFurnitureFactoryWhenCreateFurnitureThenShouldGetClassicType() {
        furnitureFactory = new ClassicFurnitureFactory();

        final var chair = furnitureFactory.createChair();
        final var coffeeTable = furnitureFactory.createCoffeeTable();
        final var sofa = furnitureFactory.createSofa();

        assertThat(chair).isInstanceOf(ClassicChair.class);
        assertThat(coffeeTable).isInstanceOf(ClassicCoffeeTable.class);
        assertThat(sofa).isInstanceOf(ClassicSofa.class);
    }

    @Test
    @DisplayName("""
        GIVEN a modern furniture factory
        WHEN create furniture
        THEN should get modern type
        """)
    void givenAModernFurnitureFactoryWhenCreateFurnitureThenShouldGetModernType() {
        furnitureFactory = new ModernFurnitureFactory();

        final var chair = furnitureFactory.createChair();
        final var coffeeTable = furnitureFactory.createCoffeeTable();
        final var sofa = furnitureFactory.createSofa();

        assertThat(chair).isInstanceOf(ModernChair.class);
        assertThat(coffeeTable).isInstanceOf(ModernCoffeeTable.class);
        assertThat(sofa).isInstanceOf(ModernSofa.class);
    }

}

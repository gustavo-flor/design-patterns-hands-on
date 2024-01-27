package com.github.gustavoflor.dpho.creational.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryMethodTest {

    private Logistics logistics;

    @Test
    @DisplayName("""
        GIVEN a boat logistics
        WHEN get transport
        THEN should return a boat
        """)
    void givenABoatLogisticsWhenGetTransportThenShouldReturnABoat() {
        logistics = new BoatLogistics();

        final var transport = logistics.getTransport();

        assertThat(transport).isInstanceOf(Boat.class);
    }

    @Test
    @DisplayName("""
        GIVEN a truck logistics
        WHEN get transport
        THEN should return a truck
        """)
    void givenATruckLogisticsWhenGetTransportThenShouldReturnATruck() {
        logistics = new TruckLogistics();

        final var transport = logistics.getTransport();

        assertThat(transport).isInstanceOf(Truck.class);
    }

}

package com.github.gustavoflor.dpho.creational.factorymethod;

public interface Logistics {

    default void planDelivery() {
        final var transport = getTransport();

        transport.deliver();
    }

    Transport getTransport();

}

package com.github.gustavoflor.dpho.creational.factorymethod;

public class BoatLogistics implements Logistics {
    @Override
    public Transport getTransport() {
        return new Boat();
    }
}

package com.github.gustavoflor.dpho.creational.factorymethod;

public class TruckLogistics implements Logistics {
    @Override
    public Transport getTransport() {
        return new Truck();
    }
}

package com.github.gustavoflor.dpho.creational.abstractfactory;

public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ClassicCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ClassicSofa();
    }
}

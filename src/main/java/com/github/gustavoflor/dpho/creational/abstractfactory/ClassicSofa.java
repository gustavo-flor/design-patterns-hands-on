package com.github.gustavoflor.dpho.creational.abstractfactory;

public class ClassicSofa implements Sofa {

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public boolean hasSupports() {
        return true;
    }

}

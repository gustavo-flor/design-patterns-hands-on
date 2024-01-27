package com.github.gustavoflor.dpho.creational.abstractfactory;

public interface Sofa {

    boolean hasLegs();

    default void sitOn() {
        // do something
    }

    boolean hasSupports();

}

package com.github.gustavoflor.dpho.creational.abstractfactory;

public interface Chair {

    boolean hasLegs();

    default void sitOn() {
        // do something
    }

}

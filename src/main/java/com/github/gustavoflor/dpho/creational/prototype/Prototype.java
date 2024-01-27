package com.github.gustavoflor.dpho.creational.prototype;

public interface Prototype<T extends Prototype<T>> {

    T getClone();

}

package com.github.gustavoflor.dpho.structural.decorator;

public class Person {

    public void sayHi() {
        say("Hi!");
    }

    public void say(String message) {
        System.out.println(message);
    }

}

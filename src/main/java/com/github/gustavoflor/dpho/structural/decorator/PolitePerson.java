package com.github.gustavoflor.dpho.structural.decorator;

public class PolitePerson {

    private final Person person;

    public PolitePerson(Person person) {
        this.person = person;
    }

    public void sayHi() {
        person.sayHi();
        person.say("How are you?");
    }

}

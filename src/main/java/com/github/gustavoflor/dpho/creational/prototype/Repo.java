package com.github.gustavoflor.dpho.creational.prototype;

public record Repo(String name, boolean visibility) implements Prototype<Repo> {

    @Override
    public Repo getClone() {
        return new Repo(name, visibility);
    }

}

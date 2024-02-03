package com.github.gustavoflor.dpho.structural.flyweight;

public record TreeType(String name, String color) {

    public void point(final int x, final int y) {
        System.out.printf("%s tree with %s color on coords %s,%s%n", name, color, x, y);
    }

}

package com.github.gustavoflor.dpho.structural.flyweight;

public record Tree(int x, int y, TreeType type) {

    public void point() {
        type.point(x, y);
    }

}

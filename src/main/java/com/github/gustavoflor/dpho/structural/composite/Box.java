package com.github.gustavoflor.dpho.structural.composite;

import java.util.List;

public class Box implements Component {

    private final List<Component> components;

    public Box(List<Component> components) {
        this.components = components;
    }

    @Override
    public float getPrice() {
        return components.stream()
            .map(Component::getPrice)
            .reduce(Float::sum)
            .orElse(0.0f) * 2;
    }
}

package com.github.gustavoflor.dpho.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class TreeFactory {

    private final List<TreeType> treeTypes = new ArrayList<>();

    public synchronized TreeType getTreeType(final String name, final String color) {
        final var treeType = treeTypes.stream()
            .filter(it -> it.name().equals(name) && it.color().equals(color))
            .findFirst()
            .orElse(null);
        if (nonNull(treeType)) {
            return treeType;
        }
        final var value = new TreeType(name, color);
        treeTypes.add(value);
        return value;
    }

    public int getTreeTypesSize() {
        return treeTypes.size();
    }
}

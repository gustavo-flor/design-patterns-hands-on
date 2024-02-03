package com.github.gustavoflor.dpho.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Forest {

    private final TreeFactory treeFactory;
    private final List<Tree> trees = new ArrayList<>();

    public Forest(TreeFactory treeFactory) {
        this.treeFactory = treeFactory;
    }

    public void addTree(final int x, final int y, final String name, final String color) {
        final var type = treeFactory.getTreeType(name, color);
        final var tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void point() {
        trees.forEach(Tree::point);
    }

    public int getTreesSize() {
        return trees.size();
    }
}

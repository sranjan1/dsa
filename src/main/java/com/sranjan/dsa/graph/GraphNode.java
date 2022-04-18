package com.sranjan.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    T value;
    List<GraphNode<T>> neighbours;

    public GraphNode(T value) {
        this.value = value;
        this.neighbours = new ArrayList<>();
    }
    public void addEdge(GraphNode<T> to) {
        this.neighbours.add(to);
        to.neighbours.add(this);
    }
}

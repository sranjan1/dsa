package com.sranjan.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode<T> {
    T value;
    List<DirectedGraphNode<T>> neighbours;

    public DirectedGraphNode(T value) {
        this.value = value;
        this.neighbours = new ArrayList<>();
    }
    public void addEdge(DirectedGraphNode<T> to) {
        this.neighbours.add(to);
    }
}

package com.sranjan.dsa.graph;

import com.sranjan.dsa.linkedlist.LinkedListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {

    public static void main(String[] args) {
        GraphNode<Integer> n0 = new GraphNode<>(0);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n5 = new GraphNode<>(5);

        n5.addEdge(n0);
        n5.addEdge(n2);
        n4.addEdge(n2);
        n4.addEdge(n1);
        n0.addEdge(n3);
        n0.addEdge(n2);
        bfs(n5);
    }

    public static void bfs(GraphNode<Integer> startNode){
        Queue<GraphNode<Integer>> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode.value);
        while(!queue.isEmpty()) {
            GraphNode<Integer> currentNode = queue.remove();
            System.out.println(currentNode.value+" ----------->");
            for(GraphNode<Integer> node : currentNode.neighbours) {
                if(!visited.contains(node.value)) {
                    visited.add(node.value);
                    queue.add(node);
                }
            }
        }

    }

    public static void dfs(GraphNode<Integer> startNode) {

    }

}

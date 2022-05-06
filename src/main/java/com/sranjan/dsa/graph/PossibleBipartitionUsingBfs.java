package com.sranjan.dsa.graph;

import java.util.*;

public class PossibleBipartitionUsingBfs {

    public static void main(String[] args) {
        int[][] dislikes1 = {{1,2},{1,3},{2,4}};
        int[][] dislikes2 = {{1,2},{1,3},{2,3}};
        int[][] dislikes3 = {{1,2},{2,3},{3,4}, {4,5}, {1,5}};
        System.out.println(new PossibleBipartitionUsingBfs().possibleBipartition(4, dislikes1));
        System.out.println(new PossibleBipartitionUsingBfs().possibleBipartition(3, dislikes2));
        System.out.println(new PossibleBipartitionUsingBfs().possibleBipartition(5, dislikes3));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = buildGraph(n, dislikes);
        int[] colour = new int[n+1];
        for(int i=1;i<=n;i++) {
            if(colour[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                colour[i] = 1;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int current = queue.poll();
                    for(int node: graph.get(current)) {
                        if (colour[node] == colour[current]) {
                            return false;
                        }
                        else if(colour[node] == 0) {
                            queue.offer(node);
                            colour[node] = -colour[current];
                        }
                    }
                }

            }
        }

        return true;
    }

    private List<List<Integer>> buildGraph(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N+1);

        for(int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());
        for(int i=0; i<dislikes.length; i++) {
            int source = dislikes[i][0];
            int destination = dislikes[i][1];
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        return graph;
    }
}

package com.sranjan.dsa.graph;

public class BipartiteGraphUsingDfs {

    public static void main(String[] args) {
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(new BipartiteGraphUsingDfs().isBipartite(graph1));
        System.out.println(new BipartiteGraphUsingDfs().isBipartite(graph2));
    }

    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(colour[i] == 0 && !isValidColour(graph, colour, 1, i)){
                return false;
            }
        }
        return true;
    }

    public boolean isValidColour(int[][] graph, int[] colour, int c, int node) {
        if(colour[node] != 0) return colour[node] == c;
        colour[node] = c;
        for(int n : graph[node]) {
            if(!isValidColour(graph, colour, -c, n))
                return false;
        }
        return true;
    }


}

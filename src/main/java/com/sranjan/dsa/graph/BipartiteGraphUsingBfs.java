package com.sranjan.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphUsingBfs {
    public static void main(String[] args) {
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(new BipartiteGraphUsingDfs().isBipartite(graph1));
        System.out.println(new BipartiteGraphUsingDfs().isBipartite(graph2));
    }

    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(colour[i] == 0){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                colour[i] = 1;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int n: graph[node]){
                        if(colour[n] == colour[node]) return false;
                        else if(colour[n] == 0){
                            queue.offer(n);
                            colour[n] = -1;
                        }
                    }
                }
            }
        }
        return true;
    }
}

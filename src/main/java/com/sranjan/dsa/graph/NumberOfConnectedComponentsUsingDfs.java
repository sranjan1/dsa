package com.sranjan.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsUsingDfs {
    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][]{{0,1},{1,2}, {3,4}}));
        System.out.println(countComponents(5, new int[][]{{0,1},{1,2}, {2,3},{3,4}}));
    }
    public static int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int j=0; j<edges.length;j++){
            adjList.get(edges[j][0]).add(edges[j][1]);
            adjList.get(edges[j][1]).add(edges[j][0]);
        }
        for(int k=0; k<n; k++){
            if(!visited[k]){
                count++;
                dfs(k,adjList,visited);
            }
        }
        return count;
    }

    private static void dfs(int index, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[index] = true;
        for(int neighbour : adjList.get(index)){
            if(!visited[neighbour]){
                dfs(neighbour, adjList, visited);
            }
        }
    }
}

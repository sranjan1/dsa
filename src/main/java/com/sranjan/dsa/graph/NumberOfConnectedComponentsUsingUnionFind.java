package com.sranjan.dsa.graph;

import java.util.Arrays;

public class NumberOfConnectedComponentsUsingUnionFind {
    private int[] parent;

    public NumberOfConnectedComponentsUsingUnionFind(int n){
        this.parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsUsingUnionFind obj = new NumberOfConnectedComponentsUsingUnionFind(5);
        System.out.println(obj.countComponents(5, new int[][]{{0,1},{1,2}, {3,4}}));
        System.out.println(obj.countComponents(5, new int[][]{{0,1},{1,2}, {2,3},{3,4}}));
    }

    public int countComponents(int n, int[][] edges){
        for(int i=0;i < edges.length;i++){
            union(edges[i][0], edges[i][1]);
        }
        int count = 0;
        for(int i: parent){
            if(i == -1)
                count++;
        }
        return count;
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        //Already have same parent
        if(parentX == parentY)
            return;
        parent[parentX] = parentY;
    }

    private int find(int x) {
        if(parent[x] == -1)
            return x;
        return find(parent[x]);
    }
}

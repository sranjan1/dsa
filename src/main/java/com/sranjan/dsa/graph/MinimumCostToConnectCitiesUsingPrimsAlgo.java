package com.sranjan.dsa.graph;

public class MinimumCostToConnectCitiesUsingPrimsAlgo {
    public static void main(String[] args) {
        // Input 1
        int n1 = 5;
        int city1[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println(findCost(n1, city1));

        // Input 2
        int n2 = 6;
        int city2[][] = { { 0, 1, 1, 100, 0, 0 },
                { 1, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 },
                { 100, 0, 0, 0, 2, 2 },
                { 0, 0, 0, 2, 0, 2 },
                { 0, 0, 0, 2, 2, 0 } };

        System.out.println(findCost(n2, city2));
    }

    private static int findCost(int numberOfVertices, int[][] city) {
        // Array to store the parent node of a
        // particular node.
        int parent[] = new int[numberOfVertices];

        // Array to store key value of each node.
        int keyval[] = new int[numberOfVertices];

        // Boolean Array to hold bool values whether
        // a node is included in MST or not.
        boolean mstset[] = new boolean[numberOfVertices];

        // Set all the key values to infinite and
        // none of the nodes is included in MST.
        for(int i = 0; i < numberOfVertices; i++)
        {
            keyval[i] = Integer.MAX_VALUE;
            mstset[i] = false;
        }

        // Start to find the MST from node 0.
        // Parent of node 0 is none so set -1.
        // key value or minimum cost to reach
        // 0th node from 0th node is 0.
        parent[0] = -1;
        keyval[0] = 0;
        // Find the rest n-1 nodes of MST.
        for(int i = 0; i < numberOfVertices - 1; i++)
        {

            // First find out the minimum node
            // among the nodes which are not yet
            // included in MST.
            int u = minnode(numberOfVertices, keyval, mstset);

            // Now the uth node is included in MST.
            mstset[u] = true;

            // Update the values of neighbor
            // nodes of u which are not yet
            // included in MST.
            for(int v = 0; v < numberOfVertices; v++)
            {
                if (city[u][v] > 0 &&  mstset[v] == false && city[u][v] < keyval[v])
                {
                    keyval[v] = city[u][v];
                    parent[v] = u;
                }
            }
        }
        // Find out the cost by adding
        // the edge values of MST.
        int cost = 0;
        for(int i = 1; i < numberOfVertices; i++)
            cost += city[parent[i]][i];

        System.out.println(cost);
        return cost;
    }

    private static int minnode(int numberOfVertices, int[] keyval, boolean[] mstset) {
        int mini = Integer.MAX_VALUE;
        int mini_index = 0;

        // Loop through all the values of the nodes
        // which are not yet included in MST and find
        // the minimum valued one.
        for(int i = 0; i < numberOfVertices; i++)
        {
            if (mstset[i] == false && keyval[i] < mini)
            {
                mini = keyval[i];
                mini_index = i;
            }
        }
        return mini_index;
    }
}

package com.sranjan.dsa.graph;

import com.sranjan.dsa.linkedlist.LinkedListNode;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
//        GraphNode<Integer> n0 = new GraphNode<>(0);
//        GraphNode<Integer> n1 = new GraphNode<>(1);
//        GraphNode<Integer> n2 = new GraphNode<>(2);
//        GraphNode<Integer> n3 = new GraphNode<>(3);
//        GraphNode<Integer> n4 = new GraphNode<>(4);
//        GraphNode<Integer> n5 = new GraphNode<>(5);
//
//        n5.addEdge(n0);
//        n5.addEdge(n2);
//        n4.addEdge(n2);
//        n4.addEdge(n1);
//        n0.addEdge(n3);
//        n0.addEdge(n2);
//        bfs(n5);
        int x1 = 2;
        int x2 = 3;
        int y1 = 4;
        int y2  = 5;

         Math.pow((x1-x2),2);
        int numCourses = 4;
        int[][] prerequisites = {{2,0},{2,1},{3,2},{3,1}};
//        canFinish(4,prerequisites);
//        canFinishUsingAdjacencyMatrix(4,prerequisites);
        System.out.println(canFinishUsingAdjacencyMatrix(4,prerequisites));
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }

    public static boolean canFinishUsingAdjacencyMatrix(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
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

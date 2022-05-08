package com.sranjan.dsa.graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> sortedList = new ArrayList<>(numCourses);
        if(prerequisites == null || prerequisites.length == 0 && numCourses!=0) {
            for(int i=0;i<numCourses;i++){
                sortedList.add(i);
            }
            return sortedList.stream().mapToInt(i->i).toArray();
        }


        //We need 4 data structures here
        // Map for the adj list
        // Array to store indegree for each node
        // Queue for the actual Kahn's algo using BFS
        // Array to store the final answer
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();


        //Create the adj matrix as a map
        // with all keys pointing to empty lists
        for(int k = 0; k<numCourses; k++){
            preMap.put(k,new ArrayList<>());
        }

        //Create InDegree array
        for(int i = 0; i<prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            preMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //Check if inDegree is 0 for any
        for(int j=0; j<inDegree.length; j++){
            if(inDegree[j] == 0){
                queue.offer(j);
            }
        }

        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            sortedList.add(currentCourse);
            List<Integer> neihboursToCurrentCourse = preMap.get(currentCourse);
            for(Integer course: neihboursToCurrentCourse){
                inDegree[course]--;
                if(inDegree[course] == 0){
                    queue.offer(course);
                }
            }

        }

        for(int i: inDegree){
            if(i!= 0){
                return new int[0];
            }
        }

        return sortedList.stream().mapToInt(i->i).toArray();
    }
}

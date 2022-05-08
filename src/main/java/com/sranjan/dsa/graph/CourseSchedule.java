package com.sranjan.dsa.graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> taken = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                taken.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer dependentCourse : map.getOrDefault(removed, new ArrayList<>())) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    taken.add(dependentCourse);
                    queue.add(dependentCourse);
                }
            }
        }
        return taken.size() == numCourses;
    }
}

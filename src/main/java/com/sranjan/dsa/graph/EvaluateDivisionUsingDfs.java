package com.sranjan.dsa.graph;

import java.util.*;

public class EvaluateDivisionUsingDfs {
    private final Map<String, Map<String, Double>> map = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for(int i = 0; i < equations.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            double value = values[i];
            map.putIfAbsent(x, new HashMap<String, Double>());
            map.putIfAbsent(y, new HashMap<String, Double>());
            map.get(x).put(y, value);
            map.get(y).put(x, 1.0 / value);
        }
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][0])) res[i] = -1.0;
            else res[i] = dfs(queries[i][0], queries[i][1], new HashSet<String>());
        }
        return res;
    }
    double dfs(String source, String destination, Set<String> visited) {
        if(source.equals(destination)) return 1.0;
        visited.add(source);
        if(!map.containsKey(source)) return -1.0;
        for(String neighbor : map.get(source).keySet()) {
            if(visited.contains(neighbor)) continue;
            double t = dfs(neighbor, destination, visited);
            if(t > -1.0) return t * map.get(source).get(neighbor);
        }
        return -1.0;
    }
}
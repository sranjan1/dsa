package com.sranjan.dsa.graph;

import java.util.*;

public class EvaluateDivisionUsingDfs {
    private Map<String, Map<String, Double>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) result[i] = -1.0;
            else result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return result;
    }
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        for(int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double value = values[i];
            map.putIfAbsent(x, new HashMap<String, Double>());
            map.putIfAbsent(y, new HashMap<String, Double>());
            map.get(x).put(y, value);
            map.get(y).put(x, 1.0 / value);
        }
        return map;
    }

    private double dfs(String source, String destination, Set<String> visited) {
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
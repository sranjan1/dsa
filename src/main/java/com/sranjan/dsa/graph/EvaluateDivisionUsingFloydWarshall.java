package com.sranjan.dsa.graph;

import java.util.HashMap;

public class EvaluateDivisionUsingFloydWarshall {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            graph.computeIfAbsent(equations[i][0], f -> new HashMap<>()).put(equations[i][1], values[i]);
            graph.computeIfAbsent(equations[i][1], f -> new HashMap<>()).put(equations[i][0], 1.0 / values[i]);
        }
        for(String mid : graph.keySet()) {
            for(String src : graph.get(mid).keySet()) {
                for(String dest : graph.get(mid).keySet()) {
                    double val = graph.get(src).get(mid) * graph.get(mid).get(dest);
                    graph.get(src).put(dest, val);
                }
            }
        }
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(!graph.containsKey(queries[i][0])) res[i] = -1.0;
            else res[i] = graph.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
        }
        return res;
    }
}

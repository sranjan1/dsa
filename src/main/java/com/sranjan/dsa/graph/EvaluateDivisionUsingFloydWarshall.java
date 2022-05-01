package com.sranjan.dsa.graph;

import java.util.HashMap;
import java.util.List;

public class EvaluateDivisionUsingFloydWarshall {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            graph.computeIfAbsent(equations.get(i).get(0), f -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), f -> new HashMap<>()).put(equations.get(i).get(0), 1.0 / values[i]);
        }
        for(String mid : graph.keySet()) {
            for(String src : graph.get(mid).keySet()) {
                for(String dest : graph.get(mid).keySet()) {
                    double val = graph.get(src).get(mid) * graph.get(mid).get(dest);
                    graph.get(src).put(dest, val);
                }
            }
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            if(!graph.containsKey(queries.get(i).get(0))) res[i] = -1.0;
            else res[i] = graph.get(queries.get(i).get(0)).getOrDefault(queries.get(i).get(1), -1.0);
        }
        return res;
    }
}

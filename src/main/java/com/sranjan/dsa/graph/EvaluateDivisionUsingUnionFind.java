package com.sranjan.dsa.graph;

import java.util.HashMap;
import java.util.Map;

public class EvaluateDivisionUsingUnionFind {

    public static void main(String[] args) {

    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> graph = new HashMap<>();
        Map<String, Double> ratio = new HashMap<>();
        double[] res = new double[queries.length];
        for (int i = 0; i < equations.length; i++) {
            String p0 = find(equations[i][0], graph, ratio);
            String p1 = find(equations[i][1], graph, ratio);
            graph.put(p0, p1);
            ratio.put(p0, values[i] * ratio.get(equations[i][1]) / ratio.get(equations[i][0]));
        }
        for (int i = 0; i < queries.length; i++) {
            if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String p0 = find(queries[i][0], graph, ratio);
            String p1 = find(queries[i][1], graph, ratio);
            if (!p0.equals(p1)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = ratio.get(queries[i][0]) / ratio.get(queries[i][1]);
        }
        return res;
    }

    private String find(String str, Map<String, String> graph, Map<String, Double> ratio) {
        if (!graph.containsKey(str)) {
            graph.put(str, str);
            ratio.put(str, 1.0);
            return str;
        }
        if (graph.get(str).equals(str)) return str;
        String parent = graph.get(str);
        String ancestor = find(parent, graph, ratio);
        graph.put(str, ancestor);
        ratio.put(str, ratio.get(str)*ratio.get(parent));
        return ancestor;
    }
}

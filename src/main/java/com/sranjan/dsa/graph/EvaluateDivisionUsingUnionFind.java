package com.sranjan.dsa.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivisionUsingUnionFind {

    public static void main(String[] args) {

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> graph = new HashMap<>();
        Map<String, Double> ratio = new HashMap<>();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String p0 = find(equations.get(i).get(0), graph, ratio);
            String p1 = find(equations.get(i).get(1), graph, ratio);
            graph.put(p0, p1);
            ratio.put(p0, values[i] * ratio.get(equations.get(i).get(1)) / ratio.get(equations.get(i).get(0)));
        }
        for (int i = 0; i < queries.size(); i++) {
            if (!graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1))) {
                res[i] = -1.0;
                continue;
            }
            String p0 = find(queries.get(i).get(0), graph, ratio);
            String p1 = find(queries.get(i).get(1), graph, ratio);
            if (!p0.equals(p1)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = ratio.get(queries.get(i).get(0)) / ratio.get(queries.get(i).get(1));
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

package com.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class PrintPathsInDAG {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                new int[]{1, 2},
                new int[]{3},
                new int[]{3},
                new int[]{}
        };
        PrintPathsInDAG obj = new PrintPathsInDAG();
        List<List<Integer>> ans = obj.allPathsSourceTarget(graph);
        System.out.println(ans);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return null;
        }
        int n = graph.length;

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, n - 1, curr, answer);

        return answer;
    }

    private void dfs(int[][] graph, int source, int target, List<Integer> curr, List<List<Integer>> answer) {
        if (source == target) {
            answer.add(new ArrayList<>(curr));
            return;
        }

        for (int child : graph[source]) {
            curr.add(child);
            dfs(graph, child, target, curr, answer);
            curr.remove(curr.size() - 1);
        }
    }
}

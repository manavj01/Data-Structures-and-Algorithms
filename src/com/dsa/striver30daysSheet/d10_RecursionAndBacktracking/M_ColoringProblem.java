package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class M_ColoringProblem {
    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int E = 5;
        boolean[][] Edges = {{false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false}};
        System.out.println(new M_ColoringProblem().graphColoring(Edges, M, N));
    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        return solve(0, graph, color, n, m);
    }

    public boolean solve(int node, boolean[][] graph, int[] color, int n, int M) {
        if (node == n) return true;

        for (int i = 1; i <= M; i++) {
            if (isSafe(node, graph, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, graph, color, n, M)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(int node, boolean[][] graph, int[] color, int n, int col) {
        for (int i = 0; i < graph[0].length; i++) {
            if (graph[node][i]) {
                if (color[i] == col) return false;
            }
        }
        return true;
    }
}

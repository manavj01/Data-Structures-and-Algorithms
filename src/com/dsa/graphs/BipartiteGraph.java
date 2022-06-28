package com.dsa.graphs;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) throws IOException {
        int[][] graph = new int[][]{
                new int[]{1, 2, 3},
                new int[]{0, 2},
                new int[]{0, 1, 3},
                new int[]{0, 2},
//                new int[]{1, 3},
//                new int[]{0, 2},
//                new int[]{1, 3},
//                new int[]{0, 2},
        };

        boolean bfs = isBipartiteBFS(graph);
        boolean dfs = isBipartiteDFS(graph);
        System.out.println(dfs);
    }

    // bfs solution
    public static boolean isBipartiteBFS(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfsCheck(int[][] graph, int src, int[] color) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        color[src] = 1;
        while (!que.isEmpty()) {
            int node = que.poll();
            for (Integer it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    que.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    // dfs solution
    public static boolean isBipartiteDFS(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfsCheck(i, graph, color)) return true;
            }
        }
        return false;
    }

    public static boolean dfsCheck(int src,  int[][] graph, int[] color) {

        if (color[src] == -1)color[src] =1;

        for (Integer it : graph[src]){
            if(color[it] == -1){
                color[it] = 1 - color[src];
                if (!dfsCheck(it, graph, color)){
                    return false;
                }else if (color[src] == color[it]){
                    return false;
                }
            }
        }
        return true;
    }
}

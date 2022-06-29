package com.dsa.graphs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DetectCycleDG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 1; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            adj.get(v1).add(v2);
//            adj.get(v2).add(v1);
        }
        int[][] prerequisites = new int[][]{
                new int[]{1,0}
        };
        boolean dfs = detectCycleDFS(2, adj);
        System.out.println(dfs);
    }

    public static boolean detectCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, dfsVis, adj)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int src, boolean[] vis, boolean[] dfsVis, ArrayList<ArrayList<Integer>> adj) {

        vis[src] = true;
        dfsVis[src] = true;

        for (Integer it : adj.get(src)) {
            if (!vis[it]) {
                if (dfs(it, vis, dfsVis, adj)) return true;
            } else if (dfsVis[it]) {
                return true;
            }
        }
        dfsVis[src] = false;
        return false;
    }
}

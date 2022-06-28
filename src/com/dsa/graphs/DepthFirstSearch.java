package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        System.out.println(adj);
        ArrayList<Integer> dfs = dfsOfGraph(V, adj);
        System.out.println(dfs);
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];
        int c = 0;
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, storeDfs);
                c++; // counting multiple components in a graph
            }
        }
        System.out.println(c);
        return storeDfs;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, storeDfs);
            }
        }
    }
}

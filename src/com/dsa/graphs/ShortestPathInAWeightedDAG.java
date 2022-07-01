package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInAWeightedDAG {
    static class Pair {
        int edge;
        int weight;

        Pair(int _v, int _w) {
            edge = _v;
            weight = _w;
        }

        int getEdge() {
            return edge;
        }

        int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        shortestPath(0, adj, n);
    }

    public static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N) {
        Stack<Integer> st = new Stack<>();
        int[] dist = new int[N];
        boolean[] vis = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topologicalSortUtil(i, vis, st, adj);
            }
        }

        dist[s] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            // if node has been reached previously
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.weight < dist[it.getEdge()]) {
                        dist[it.edge] = dist[node] + it.getWeight();
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void topologicalSortUtil(int src, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {

        if (!vis[src]) {
            vis[src] = true;
            for (Pair it : adj.get(src)) {
                topologicalSortUtil(it.getEdge(), vis, st, adj);
            }
            st.add(src);
        }
    }
}

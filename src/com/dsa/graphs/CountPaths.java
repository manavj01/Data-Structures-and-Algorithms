package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CountPaths {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        ArrayList<ArrayList<Integer>> adj;
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(i, new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            String[] s1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(s1[0]);
            int destination = Integer.parseInt(s1[1]);
            countPaths(V, adj, source, destination);
        }
    }

    static int count;

    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {

        boolean[] visited = new boolean[V];
        helper(V, adj, source, destination, visited, count);
        return count;
    }

    public static boolean helper(int V, ArrayList<ArrayList<Integer>> adj, int src, int desc, boolean[] visited, int count) {

        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> edge : adj) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        if (src == desc) {
            count++;
            return true;
        }

        visited[src] = true;


        return false;
    }

}

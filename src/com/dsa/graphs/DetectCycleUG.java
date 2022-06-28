package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DetectCycleUG {
    public static class Pair {
        int node;
        int prev;

        Pair(int node, int prev) {
            this.node = node;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        boolean ans = isCycleDfs(V, adj);
        System.out.println(ans);

    }

    public static boolean isCycleDfs(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            Pair mp = new Pair(i, -1);
            if (!vis[i]) {
                if (cycleDfs(mp, i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDfs(Pair mp, int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        for (Integer it : adj.get(src)) {

            if (!vis[it]) {
                Pair child = new Pair(it, mp.node);
                if (cycleDfs(child, it, adj, vis)) return true;
            } else if (it != mp.prev && vis[it]) {
                return true;
            }
        }
        return false;
    }


    public static boolean isCycleBfs(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (cycleBfs(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleBfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {


        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(src, -1));
        vis[src] = true;
        while (!que.isEmpty()) {
            Pair mp = que.poll();
            int node = mp.node;
            int par = mp.prev;
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    que.add(new Pair(it, node));
                    vis[it] = true;
                } else if (par != it) {
                    return true;
                }
            }
        }
        return false;
    }
}
//11
//10
//1 2
//2 4
//3 5
//5 6
//6 7
//7 8
//8 9
//8 11
//9 10
//5 10
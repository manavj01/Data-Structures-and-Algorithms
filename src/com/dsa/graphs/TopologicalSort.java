package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 2; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            adj.get(v1).add(v2);
//            adj.get(v2).add(v1);
        }

        int[] sort = topoSortDFS(adj, V);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] topoSortDFS(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer> topo = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        int[] s = new int[V];
        int idx = 0;
        while (!st.isEmpty()) {
            s[idx] = st.pop();
            idx++;
        }
        return s;
    }

    public static void dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {

        vis[src] = true;
        for (int it : adj.get(src)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(src);
    }

    public static int[] topoSortBFS(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] indegree = new int[V];
        int[] topo = new int[V];

        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) que.add(i);
        }
//        int c =0;
        int ind = 0;
        while (!que.isEmpty()) {
            Integer node = que.poll();
            topo[ind++] = node;
//            c++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    que.add(it);
                }
            }
        }
//        if (c < V){
//         to check for cycle if c is less than edge
//         there is a cycle
//        }
        return topo;

    }
}

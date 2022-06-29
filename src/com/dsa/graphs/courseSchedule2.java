package com.dsa.graphs;

import java.util.*;

public class courseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2},
        };
        int numCourses = 4;
        int[] arr = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        boolean hasCycle = detectCycleDFS(numCourses, adj);
        if (hasCycle) {
            return new int[0];
        }

        int[] inDegree = new int[numCourses];
        int[] topo = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (Integer it : adj.get(i)) {
                inDegree[it]++;
            }
        }


        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) que.add(i);
        }

        int ind = 0;
        while (!que.isEmpty()) {
            Integer node = que.poll();
            topo[ind++] = node;

            for (Integer it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    que.add(it);
                }
            }
        }
        int i = 0, j = topo.length - 1;
        while (i < j) {
            int temp = topo[i];
            topo[i] = topo[j];
            topo[j] = temp;
            i++;
            j--;
        }
        return topo;
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

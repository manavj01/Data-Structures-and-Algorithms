package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortestPathInUGNonWeighted {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int src = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 11; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        System.out.println("hello");
        shortestPath(adj, V, src);
    }

    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        System.out.println(dist[V - 1]);
    }
}


//input
//0 1
//0 3
//1 3
//1 2
//2 6
//3 4
//4 5
//5 6
//6 7
//7 8
//6 8

//    int[] dist = new int[V];
//        for (int i = 0; i < V; i++) {
//        dist[i] = 1000000000;
//    }
//    Queue<Integer> q = new LinkedList<>();
//
//    dist[src] = 0;
//        q.add(src);
//
//        while (!q.isEmpty()) {
//        int node = q.poll();
//
//        for (int it : adj.get(node)) {
//            if (dist[node] + 1 < dist[it]) {
//                dist[it] = dist[node] + 1;
//                q.add(it);
//            }
//        }
//    }
//        System.out.println(dist[V - 1]);

package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestDistanceInUG {

    static class Pair {
        int edge;
        int nbr;
        int wt;

        Pair() {
        }

        Pair(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }

        int getNbr(int nbr) {
            return this.nbr = nbr;
        }

        Pair(int edge, int nbr, int wt) {
            this.edge = edge;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().split(" ");
            int edge = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            Pair u = new Pair(edge, nbr, wt);
            Pair v = new Pair(nbr, edge, wt);

            adj.get(edge).add(u);
            adj.get(nbr).add(v);

        }
        System.out.println(adj.get(0).get(0).edge + "-" + adj.get(0).get(0).nbr + " @ " + adj.get(0).get(0).wt);
        System.out.println(adj.get(0).get(1).edge + "-" + adj.get(0).get(1).nbr + " @ " + adj.get(0).get(1).wt);
        System.out.println(adj.get(1).get(0).edge + "-" + adj.get(1).get(0).nbr + " @ " + adj.get(1).get(0).wt);
        System.out.println(adj.get(1).get(1).edge + "-" + adj.get(1).get(1).nbr + " @ " + adj.get(1).get(1).wt);
        System.out.println(adj.get(2).get(0).edge + "-" + adj.get(2).get(0).nbr + " @ " + adj.get(2).get(0).wt);
        System.out.println(adj.get(2).get(1).edge + "-" + adj.get(2).get(1).nbr + " @ " + adj.get(2).get(1).wt);
        System.out.println(adj);

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        //create a distance array
        //initialize it with integer.maxvalue
        //create a priority Queue
        //add a source node to it with its distance in distance array
        //find all the adjacent nodes
        //check if dis[adjacentNode] > distance.source node + adjacent node distance
        //add in priority Queue

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<DijkstraAlgorithm.Pair> pq = new PriorityQueue<>(V, new DijkstraAlgorithm.Pair());

        distance[s] = 0;
        pq.offer(new DijkstraAlgorithm.Pair(s, 0));
        while (!pq.isEmpty()) {
            DijkstraAlgorithm.Pair node = pq.poll();

            ArrayList<ArrayList<Integer>> list = adj.get(node.vertex);
            for (ArrayList<Integer> lists : list) {
                int adjVertex = lists.get(0);
                int adjWeight = lists.get(1);

                if (distance[adjVertex] > node.weight + adjWeight) {
                    distance[adjVertex] = node.weight + adjWeight;
                    pq.offer(new DijkstraAlgorithm.Pair(adjVertex, distance[adjVertex]));
                }
            }
        }
        return distance;
    }


}

package com.dsa.graphs;


import java.io.*;
import java.util.*;


public class PrintAllPath {
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

    public static void printPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                printPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }
        visited[src] = false;

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Integer end = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>(); // keep track of nodes to process
        Deque<Integer> path  = new ArrayDeque<>(); // path generated so far

        // prime the stack with the start node
        stack.push(0);

        while (!stack.isEmpty()) {
            /* 'hack' alert
            we need an Integer object and not an int because path.peekLast()
            will return null the very first time it is called.
            you cannot compare null with an int but you can with an Integer
			*/
            Integer current = stack.peek(); /* peek, don't pop */
            if (current == path.peekLast()) {
                /*
				   when the top of the stack and the top of queue match
                   it means we have processes all this node's connections
                   there are no more paths to explore so remove the node
                   from the list of nodes to process, and from the path
                   We are backtracking to the previous point in the path, and
                   the list of nodes to process
				*/
                stack.pop();       // remove the end from the path
                path.removeLast(); // remove the end from the path
                continue;
            }
            path.offer(current);
            if (current == end) {
                /* We've found a path */
                result.add(new ArrayList(path)); /* add the path Queue as a List to the result */
                path.removeLast(); /* go back one step in the path */
                stack.pop();       /* remove the from the nodes to process */
                continue;
            }
			/*
			   we haven't seen this node before.
               add all of this node's neighbors to the stack of nodes to process
			*/
            for (int neighbor : graph[current]) {
                stack.push(neighbor);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        printPaths(graph, src, dest, visited, "" + src);
//        int[][] edgemat = new int[][]{{0,1},{1,2},{2,0}};
//        hasPaths1(vtces, edgemat,src,dest);
//        System.out.println(graph1);
    }
    static ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

    public static void hasPaths1(int v, int[][] edges, int src, int dest) {

        /* Building Graph Start */

        ArrayList<Integer>[] graph = new ArrayList[v];
        for (int i = 0 ; i < v; i++){
            graph1.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        /* Building Graph end */


        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < graph.length; i++){
            stack.add(i);
            boolean[] visited = new boolean[v];
            visited[src] = true;
            graph1.get(i).add(src);

            while (!stack.isEmpty()) {
                int current = stack.pop();
                for (int neighbor : graph[current]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        graph1.get(i).add(neighbor);
                        stack.add(neighbor);
                    }
                }
            }
        }


    }

}

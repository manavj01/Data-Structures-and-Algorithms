package com.dsa.trees.genericTree;

import java.io.*;

import static com.dsa.trees.genericTree.GenericTree.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
//        int data = Integer.parseInt(br.readLine());
//        int d1 = Integer.parseInt(br.readLine());
//        int d2 = Integer.parseInt(br.readLine());
        GenericTree.Node root = construct(arr);
//        int n2 = Integer.parseInt(br.readLine());
//        int[] arr2 = new int[n2];
//        String[] values2 = br.readLine().split(" ");
//        for (int i = 0; i < n2; i++) {
//            arr2[i] = Integer.parseInt(values2[i]);
//        }
//        Node root2 = construct(arr2);

//        boolean similar = areSimilar(root1, root2);
//        System.out.println(similar);
//        boolean mirror = areMirror(root1, root2);
//        System.out.println(mirror);
        boolean sym = IsSymmetric(root);
        System.out.println(sym);
//        int sz = size(root);
//        int m = max(root);
//        int h = height(root);
//         display(root);
//        System.out.println(h);
//        traversals(root);
//        levelOrder(root);
//        levelOrderLinewise(root);
//        levelOrderLinewise2(root);
//        levelOrderLinewise3(root);
//        levelOrderLinewise4(root);
//        levelOrderLinewiseZZ(root);
//        display(root);
//        mirror(root);
//        removeLeaves(root);
//        linearize(root);
//        linearize2(root);
//        System.out.println(find(root, data));
//        ArrayList<Integer> path = nodeToRootPath(root, data);
//        System.out.println(path);

//        int lca = lca(root,d1,d2);
//        System.out.println(lca);
//        int dist = distanceBetweenNodes(root, d1, d2);
//        System.out.println(dist);

//        display(root);
    }

}

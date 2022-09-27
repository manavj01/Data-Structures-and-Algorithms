package com.dsa.striver30daysSheet.d20_BinarySearchTree1;

public class SortedListToBST {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head;
        ListNode leftEnd = slow;
        ListNode rightHead;
        while (fast != null && fast.next != null) {
            leftEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode mid = new TreeNode(slow.val);
        rightHead = slow.next;
        leftEnd.next = null;

        if (slow != head) mid.left = sortedListToBST(head);
        mid.right = sortedListToBST(rightHead);


        return mid;


    }


    // approach 1
//     public TreeNode sortedListToBST(ListNode head) {
//         if(head == null) return null;
//         ArrayList<ListNode> arr = new ArrayList<>();
//         ListNode temp = head;

//         while(temp != null){
//             arr.add(temp);
//             temp = temp.next;
//         }
//         int lo = 0;
//         int hi =arr.size()-1;

//         TreeNode root = solve(arr,lo,hi);
//         return root;
//     }

//     public TreeNode solve(ArrayList<ListNode> arr, int lo, int hi){
//         if(lo == hi){
//             return new TreeNode(arr.get(lo).val);
//         }
//         if(lo > hi) return null;
//         int mid = (lo+hi)/2;

//         TreeNode root = new TreeNode(arr.get(mid).val);

//         root.left = solve(arr,lo,mid-1);
//         root.right = solve(arr,mid+1,hi);

//         return root;
//     }
}

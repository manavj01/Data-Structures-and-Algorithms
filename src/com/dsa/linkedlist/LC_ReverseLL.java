package com.dsa.linkedlist;

public class LC_ReverseLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();


    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sizeOfLL = head;
        int size =0;
        while(sizeOfLL != null){
            sizeOfLL = sizeOfLL.next;
            size++;
        }
        if(head.next == null){
            return head;
        }else{
            while (left < right) {
                ListNode leftnode = getNodeAt(left,head);
                ListNode rightnode = getNodeAt(right,head);

                ListNode temp = leftnode;
                leftnode = rightnode;
                rightnode = temp;

                left++;
                right--;
            }
            return head;

        }
    }
    private ListNode getNodeAt(int idx, ListNode head) {
        ListNode temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }
}

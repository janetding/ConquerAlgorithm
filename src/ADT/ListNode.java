package ADT;

/**
 * Created by janet1 on 5/29/18.
 */
//public class ListNode {
//    public int val;
//    public ListNode next;
//    private static int size = 0;
//
//    public int size(){
//        return size();
//    }
//    public ListNode(int x) { val = x; }
//
//    public static ListNode build(int[] arr){
//        size = arr.length;
//        return null;
//    }
//}

import java.util.Scanner;

// Definition for singly-linked list
public class ListNode {
//    public int val;
//    public ListNode next;
//    public ListNode(int x){
//        val = x;
//    }
//
//    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int v) {
            this.val= v;
            this.next = null;
        }

        public ListNode() {
            this(0);
        }




    public static void print(ListNode head) {
        if(head == null)
            return;

        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static ListNode generateLinkedList(String abc) {
        System.out.println("Please enter a binary number");
        String input = new Scanner(System.in).next();

        ListNode[] nodes = new ListNode[input.length() + 1];

        for (int i = 0; i < input.length(); i++) {
            //char at i; string.valueOf get string value;
            //string = "1234" --> 1, 2, 3, 4
            nodes[i] = new ListNode(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        return nodes[0];
    }

    public static ListNode generateLinkedList(int n) {
        if (n == 0) return null;

        ListNode[] nodes = new ListNode[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ListNode(i);
        }

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        return nodes[0];
    }
}

package Stack;

import ADT.ListNode;

/**
 * Created by janet1 on 7/11/18.
 */
public class reverseLinkedList {
    public ListNode reversell (ListNode head){
       ListNode prev = null;
       while(head != null){
           ListNode temp = head.next;
           head.next = prev;
           prev = head;
           head = temp;
           return prev;
       }


        return prev;
    }

    public static void main(String[] args) {
        reverseLinkedList list = new reverseLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        System.out.println(list.reversell(node1));
////            LinkedList list = new LinkedList();
//Li
//            list.head = new ListNode(2);
//            list.head.next = new Node(15);
//            list.head.next.next = new Node(4);
//            list.head.next.next.next = new Node(20);
//
//            System.out.println("Given Linked list");
//            list.printList(head);
//            head = list.reverse(head);
            System.out.println("");
//            System.out.println("Reversed linked list ");
//            list.printList(head);
        }
    private static void display(ListNode head) {
        if(head == null)
            return;

        while (head != null){
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");

            head = head.next;

        }

        System.out.println();
    }
    }



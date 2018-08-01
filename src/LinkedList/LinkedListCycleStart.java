package LinkedList;

import ADT.ListNode;

import java.util.LinkedList;

/**
 * Created by janet1 on 7/14/18.
 */
public class LinkedListCycleStart {
    public static ListNode hasCycle(ListNode head) {
        if (head == null) return null;
        ListNode quick = head;
        ListNode slow = head;
        ListNode cur = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {  // find the first intersection point
                while (cur != slow) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode node2 = new ListNode(10);
//        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(11);
//        ListNode node5 = new ListNode(12);
//        DetectCycle dc = new DetectCycle();
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(9);


        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        ListNode cycleStartNode = hasCycle(head);

        if (cycleStartNode == null) {
            System.out.println("No cycle exists.");
        } else {
            System.out.println(cycleStartNode.val);
        }
    }

}



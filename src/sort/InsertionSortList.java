
package sort;

import ADT.ListNode;



/**
 * Created by janet1 on 5/29/18.
 */


public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(3);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        System.out.println("Before sorting the linked list is: ");

        display(head);
        System.out.println();

        System.out.println("After sorting the linked list is: ");

head = insertionSortList(head);
        display(insertionSortList(head));

//        int[] arr = {1,2,3};
//
//        ListNode head1 = ListNode.build(arr);
//        head1.size();

    }

    private static void display(ListNode head) {
        if (head == null)
            return;

        while (head != null ){
            System.out.print(head.val);
           if (head.next != null)
                System.out.print("->");

            head = head.next;
        }

    }
}

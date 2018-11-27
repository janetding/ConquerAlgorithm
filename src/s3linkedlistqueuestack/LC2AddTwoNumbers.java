package s3linkedlistqueuestack;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * Created by janet1 on 9/2/18.
 *
 */

class ListNodeNew{
    int val;
    ListNodeNew next;
    ListNodeNew(int value){
        val = value;
    }
}

public class LC2AddTwoNumbers {

    static  ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode( - 1);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0 ;

        while( p!= null || q != null ){
            int x = ( p != null ) ? (int)p.val : 0;
            int y = ( q != null ) ? (int)q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode( sum % 10 );
            curr = curr.next;

            if( p != null ) p = p.next;
            if( q != null ) q = q.next;
        }
        if( carry > 0) curr.next = new ListNode(carry);

        return  dummyHead.next;
    }

//    static ListNode addTwoNumbersOne(ListNode l1, ListNode l2) {
//        if(l1 == null && l2 == null){
//            return null;
//        }
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        int sum = 0;
//        while(l1 != null || l2 != null){
//            sum /= 10;
//            if(l1 != null){
//                sum +=  (int)(l1.val) + sum;
//                l1 = l1.next;
//            }
//            if(l2 != null){
//                sum += (int)l2.val;
//                l2 = l2.next;
//            }
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//        }
//        if(sum / 10 == 1){
//            cur.next = new ListNode(1);
//        }
//        return dummy.next;
//    }


    public static void main(String[] args) {
    /*
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    */
        ListNodeNew head = new ListNodeNew(2);
        ListNodeNew node1 = new ListNodeNew(4);
        ListNodeNew node2 = new ListNodeNew(3);
        head.next = node1;
        node1.next = node2;

        ListNodeNew headOne = new ListNodeNew(5);
        ListNodeNew nodeOne = new ListNodeNew(6);
        ListNodeNew nodeTwo = new ListNodeNew(4);
        headOne.next = nodeOne;
        nodeOne.next = nodeTwo;

        StringBuilder sb1 = new StringBuilder();
        while ( head!=null ) {
            sb1.append(head.val);
            if(head.next != null){
                sb1.append("->");
            }
            head = head.next;
        }
        System.out.println("Input one: " + sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        while ( headOne!= null){
            sb2.append(headOne.val);
            if( headOne.next!= null){
                sb2.append("->");
            }
            headOne = headOne.next;
        }
        System.out.println("Input two: " + sb2.toString());

        ListNode l1 = ListNode.generateLinkedList(342);
//        ListNode.print(l1);

        ListNode l2 = ListNode.generateLinkedList(465);

        System.out.println("Sum up: ");
        ListNode.print(addTwoNumbers(l1, l2));
    }
}

package s3linkedlistqueuestack;
import ADT.ListNode;

/**
 * Created by janet1 on 9/4/18.
 */
public class LC24SwapNodes {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode first, second;

        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;

            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 3; i++) {
            ListNode head = ListNode.generateLinkedList(3);
            System.out.print("Before swapping by pair:\t");
            ListNode.print(head);

            System.out.print("After swapping by pair: \t");
            ListNode newHead = swapPairs(head);

            ListNode.print(newHead);
            System.out.println();

//            ListNode head = new ListNode(1);
//            ListNode node1 = new ListNode(2);
//            ListNode node2 = new ListNode(3);
//            ListNode node3 = new ListNode(4);
//            head.next = node1;
//            node1.next = node2;
//            node2.next = node3;
//
//            StringBuffer sb = new StringBuffer();
//            while( head!=null  ){
//                sb.append(head.val);
//                if( head.next!=null ){
//                    sb.append("->");
//                }
//                head = head.next;
//            }
//        System.out.println("Swap pairs: " + sb.toString());
//        }
        }
    }
}

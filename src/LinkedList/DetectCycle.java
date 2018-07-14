package LinkedList;
import ADT.ListNode;

/**
 * Created by janet1 on 7/14/18.
 */
public class DetectCycle {
    private static boolean hasCycle(ListNode head){
        if(head == null) return false ;
        ListNode quick = head;
        ListNode slow = head;

        while(quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow) {
                return true;
            }
        }return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(11);
        ListNode node5 = new ListNode(12);
        DetectCycle dc = new DetectCycle();
        System.out.println(dc.hasCycle(head));
    }



}

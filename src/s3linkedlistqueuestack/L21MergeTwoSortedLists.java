package s3linkedlistqueuestack;

/**
 * Created by janet1 on 9/3/18.
 */
public class L21MergeTwoSortedLists {
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (l1 != null && l2 != null) {
                if ((int) l1.val < (int) l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null)
                curr.next = l1;

            if (l2 != null)
                curr.next = l2;

            return dummy.next;
            }

    private static ListNode mergeTwoListNoDummy(ListNode l1, ListNode l2){
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;

        ListNode head, cur;

        if((int) l1.val < (int)l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        // sign current point point to head
        cur = head;

        while( l1!=null && l2!=null){
            if((int)l1.val <(int)l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if( l1!=null ) cur.next = l1;
        if( l2!=null ) cur.next = l2;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.generateLinkedList(124);
        ListNode.print(l1);
        ListNode l2 = ListNode.generateLinkedList(134);
        ListNode.print(l2);
        System.out.println("After merging l1 and l2: ");
//        ListNode.print(mergeTwoLists(l1, l2));
        ListNode.print(mergeTwoListNoDummy(l1, l2));
    }
}

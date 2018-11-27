package s3linkedlistqueuestack;

/**
 * Created by janet1 on 9/3/18.
 */
public class AddTwoNum {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0;

        while( p!= null || q!=null ){
            int x = ( p!= null ) ? (int)p.val : 0;
            int y = ( q!= null ) ? (int)q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if( p != null) p = p.next;
            if( q != null) q = q.next;
        }

        if ( carry > 0 ) curr.next = new ListNode(carry);

        return  dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.generateLinkedList(342);
        ListNode.print(l1);

        ListNode l2 = ListNode.generateLinkedList(465);
        ListNode.print(l2);

        ListNode.print(addTwoNumbers(l1, l2));
    }
}

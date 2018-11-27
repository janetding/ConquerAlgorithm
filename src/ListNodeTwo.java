import s3linkedlistqueuestack.ListNode;

/**
 * Created by janet1 on 9/3/18.
 */
public class ListNodeTwo {
    public static void main(String[] args) {
       /*     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)     Output: 7 -> 0 -> 8     Explanation: 342 + 465 = 807.     */
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;

        ListNode headOne = new ListNode(5);
        ListNode nodeOne = new ListNode(6);
        ListNode nodeTwo = new ListNode(4);

        headOne.next = nodeOne;
        nodeOne.next = nodeTwo;

        StringBuilder sb = new StringBuilder();
        while ( head!=null ){
            sb.append(head.val);
            if(head.next!=null) {
                sb.append("->");
            }
               head = head.next;
        }
        System.out.println("Input one: " + sb.toString());

        StringBuffer sb2 = new StringBuffer();
        while ( headOne!= null ){
            sb2.append(headOne.val);
            if( headOne.next!= null){
                sb2.append("->");
            }
            headOne = headOne.next;
        }
        System.out.println("Input two: " + sb2.toString());
    }
}

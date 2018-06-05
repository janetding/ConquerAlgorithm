package ADT;

/**
 * Created by janet1 on 6/1/18.
 */
public class displayMethod {
    private static void display(ListNode head) {
        if (head == null)
            return;

        while (head != null ){
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
}}

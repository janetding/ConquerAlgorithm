package s3linkedlistqueuestack;

import ADT.ListNode;

import java.util.Stack;

/**
 * Created by janet1 on 9/1/18.
 */
public class BinaryLinkedList {
    private int carry = 1;

    public ListNode increamentByOne(ListNode head) {

        if (head == null) return head;

        incrementHelperOne(head);

        if (carry == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    private void incrementHelperOne(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();

            tmp.val = (int) tmp.val + carry;
            carry = (int) tmp.val / 2;
            tmp.val = (int) tmp.val % 2;
        }
    }

    private void incrementHelper(ListNode head) {
        if (head == null) return;

        incrementHelper(head.next);
        head.val = (int) head.val + carry;
        carry = (int) head.val / 2;
        head.val = (int) head.val % 2;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateLinkedList("abc");

        System.out.println("List one is : ");
        ListNode.print(head);

        ListNode newHead = new BinaryLinkedList().increamentByOne(head);
        System.out.println("After adding one: ");
        ListNode.print(newHead);

        ListNode head1 = ListNode.generateLinkedList("def");
        System.out.println("List two is : ");
        ListNode.print(head1);

        ListNode newHead1 = addNode(head, head1);
        System.out.println("Sum up: ");
        ListNode.print(newHead1);

    }

    private static ListNode addNode(ListNode head1, ListNode head2) {
        int length1 = 0, length2 = 0;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null) {
            stack1.push(curr1);
            length1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            stack2.push(curr2);
            length2++;
            curr2 = curr2.next;
        }

        if (length1 < length2) {
            int carry = 0;
            while (!stack1.isEmpty()) {
                ListNode temp1 = stack1.pop();
                ListNode temp2 = stack2.pop();

                int sum = (int) temp1.val + (int) temp2.val + carry;

                temp2.val = sum % 2;

                carry = sum / 2;
            }

            while (!stack2.isEmpty()) {
                ListNode temp2 = stack2.pop();
                int sum = (int) temp2.val + carry;

                temp2.val = sum % 2;

                carry = sum / 2;
            }

            if (carry == 1) {
                ListNode newHead = new ListNode(1);
                newHead.next = head2;
                return newHead;
            } else {
//                int carry = 0;
                while (!stack2.isEmpty()) {
                    ListNode temp1 = stack1.pop();
                    ListNode temp2 = stack2.pop();

                    int sum = (int) temp1.val + (int) temp2.val + carry;

                    temp1.val = sum % 2;
                    carry = sum / 2;
                }

                while (!stack1.isEmpty()) {
                    ListNode temp1 = stack1.pop();
                    int sum = (int) temp1.val + carry;

                    temp1.val = sum % 2;
                    carry = sum / 2;
                }

                if (carry == 1) {
                    ListNode newHead = new ListNode(1);
                    newHead.next = head1;
                    return newHead;

                }
            }

//            return;
        }
        return null;
    }
}

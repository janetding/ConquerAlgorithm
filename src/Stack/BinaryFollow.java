package Stack;

/**
 * Created by janet1 on 7/11/18.
 */



// wrong position

        import java.util.Stack;
        import ADT.ListNode;

public class BinaryFollow {

    private int carry = 1;

    public  ListNode incrementByOne(ListNode head){

        if (head == null) {
            return head;
        }

        incrementHelper1(head);

        if (carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    private void incrementHelper1(ListNode head) {
        ListNode curr = head;

        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()){
            ListNode temp = stack.pop();

            temp.val += carry;
            carry = temp.val / 2;
            temp.val = temp.val % 2;
        }
    }

    private void incrementHelper(ListNode head) {
        if (head == null) return;

        incrementHelper(head.next);
        head.val += carry;
        carry = head.val / 2;
        head.val = head.val % 2;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode head = node1;
        System.out.println("List1 is:");
        display(head);

        ListNode newHead = new BinaryFollow().incrementByOne(head);
        System.out.println("After add 1, list1 is: ");
        display(newHead);

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(1);

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        ListNode head1 = node5;
        System.out.println("List2 is: ");
        display(head1);

        ListNode newHead1 = addNode(head,head1);
        System.out.println("After adding list1 up to list2, the new list is");
        display(newHead1);

    }


    private static ListNode addNode(ListNode head1, ListNode head2) {
        int length1 = 0, length2 = 0;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null){
            stack1.push(curr1);
            length1++;
            curr1 = curr1.next;
        }

        while (curr2 != null){
            stack2.push(curr2);
            length2++;
            curr2 = curr2.next;
        }


        if (length1 < length2){
            int carry = 0;
            while (!stack1.isEmpty()){
                ListNode temp1 = stack1.pop();
                ListNode temp2 = stack2.pop();

                int sum = carry + temp1.val + temp2.val;

                temp2.val = sum % 2;
                carry = sum / 2;
            }

            while (!stack2.isEmpty()){
                ListNode temp2 = stack2.pop();
                int sum = carry + temp2.val;

                temp2.val = sum % 2;
                carry = sum / 2;
            }

            if(carry == 1){
                ListNode newHead = new ListNode(1);
                newHead.next = head2;
                return newHead;
            }

        }else {
            int carry = 0;
            while (!stack2.isEmpty()){
                ListNode temp1 = stack1.pop();
                ListNode temp2 = stack2.pop();

                int sum = carry + temp1.val + temp2.val;

                temp1.val = sum % 2;
                carry = sum / 2;
            }

            while (!stack1.isEmpty()){
                ListNode temp1 = stack1.pop();
                int sum = carry + temp1.val;

                temp1.val = sum % 2;
                carry = sum / 2;
            }

            if(carry == 1){
                ListNode newHead = new ListNode(1);
                newHead.next = head1;
                return newHead;
            }
        }

        return null;

    }

    private static void display(ListNode head) {
        if(head == null)
            return;

        while (head != null){
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");

            head = head.next;

        }

        System.out.println();
    }

}

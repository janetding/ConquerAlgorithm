package LinkedList;
import ADT.ListNode;

/**
 * Created by janet1 on 7/17/18.
 */
/*
    Reverse a singly linked list

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class LC206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = ListNode.generateLinkedList(5);

        System.out.println("Before reverse: ");
        ListNode.print(l1);

        System.out.println("After reverse: ");
        ListNode newHead = reverseList(l1);
        ListNode.print(newHead);

    }
     /*
    Approach #1 (Recursive) [Accepted]

    Complexity analysis:
        Time complexity: O(n). Assume that n is the list's length, the time complexity is O(n)
        Space complexity: O(n). The extra space comes from implicit stack space due to the recursion.
            The recursion could go up to n levels deep.
     */
//     private static ListNode reverseList1(ListNode head){
//         if (head == null || head.next == null) return null;
//         ListNode p = reverseList1(head.next);
//         head.next.next = head;
//         return p;
//     }

    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
     /*
    Approach #1 (Iterative) [Accepted]

    Assume that we have the linked list 1->2->3->0, we would like to change it to 0->1->2->3.

    While you are traversing the list, change the current node's pointer to point to its previous element. Since a
    node dose not have reference to its previous node, you must store its previous element beforehand. You also
    need another pointer to store the next node before changing the reference. Do not forget to return the new head
    reference at the end.

    Complexity analysis
        Time complexity: O(n). Assume that n is the list's length, the time complexity is O(n)
        Space complexity: O(1) (The program will generate n (length of the list) nextTemp, but the JVM will optimize
            automatically, all the nextTemp reference will use the same address.)
     */
     private static ListNode reverseList(ListNode head){
         ListNode prev = null;
         ListNode curr = head;

         while(curr != null){
             ListNode nextTemp = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nextTemp;
         }
         return prev;

     }

}

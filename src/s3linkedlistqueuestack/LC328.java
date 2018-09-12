package s3linkedlistqueuestack;

/**
 * Created by janet1 on 9/11/18.
 * * }
 * we will keep two pointers ; one for odd, the other for even
 * store even linkedlist ; connect all the odd nodes, at the end of the odd, attach the even number linkedlist
 */

public class LC328 {
    static Node head;  // head of list

    /* Node Class */
    public static class Node {

        public int data;
        public Node next;

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public Node oddEvenList(Node head) {
        //cc
        if( head== null ) return head;
        //init
        Node p1 = head;
        Node p2 = head.next;
        Node connectHead = head.next;

        while( p1!=null && p2!=null ){
            Node t = p2.next;
            if( t==null ) break;

            p1.next = p2.next;
            p1= p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connectHead;
        return head;
    }
    public static void main(String[] args) {

        LC328 list = new LC328();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printlist(head); // print original list
        list.oddEvenList(head); // rearrange list as per ques
        System.out.println("");
        list.printlist(head); // print modified list
    }
}

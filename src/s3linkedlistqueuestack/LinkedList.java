package s3linkedlistqueuestack;

/**
 * Created by janet1 on 9/6/18.
 */
public class LinkedList {

        Node head;  // head of list

        /* Linked list Node*/
        class Node
        {
            int value;
            Node next;
            Node(int val){
                value = val;
                next = null;
            }
        }

        Node reverse(Node head, int k)
        {
            if( head==null || head.next==null || k<=1) return head;
            int count = 0;
            Node cur = head;

            while ( cur!=null && count!=k ){
                cur = cur.next;
                count++;
            }
            if( count==k ){//k+1 node is found
                cur = reverse(cur, k);
                while ( count--!=0 ){
                   Node next = head.next;
                    head.next = cur;
                    cur = head;
                    head = next;
                }
                return cur;
            }
            return head;
        }

        Node reverseOne(Node head, int k){
            Node current = head;
            Node next = null;
            Node prev = null;

            int count = 0;

       /* Reverse first k nodes of linked list */
            while (count < k && current != null)
            {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;

                count++;
            }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
            if (next != null)
                head.next = reverse(next, k);

            // prev is now head of input list
            return prev;
        }


    /* Utility functions */

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
            new_node.next = head;

        /* 4. Move the head to point to new Node */
            head = new_node;
        }

        /* Function to print linked list */
        void printList()
        {
            Node temp = head;
            while (temp != null)
            {
                System.out.print(temp.value+" ");
                temp = temp.next;

            }

            System.out.println();
        }

        /* Drier program to test above functions */
        public static void main(String args[])
        {
            LinkedList ls = new LinkedList();
            /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
//            ls.push(5);
            ls.push(4);
            ls.push(3);
            ls.push(2);
            ls.push(1);

            System.out.println("Given Linked List: ");
            ls.printList();
            ls.head = ls.reverse(ls.head, 2);
            System.out.println("Reversed List one: ");
            ls.printList();

            System.out.println("Reversed List two: " );
            ls.head = ls.reverseOne(ls.head, 3);
            ls.printList();

            ListNodeNew headOne = new ListNodeNew(5);
            ListNodeNew nodeOne = new ListNodeNew(6);
            ListNodeNew nodeTwo = new ListNodeNew(4);
            headOne.next = nodeOne;
            nodeOne.next = nodeTwo;

            StringBuilder sb = new StringBuilder();
            while ( headOne!=null ) {
                sb.append(headOne.val);
                if( headOne.next!=null ){
                    sb.append("->");
                }
                headOne = headOne.next;
            }
            System.out.println("Given LinkedList two: " + sb.toString());
        }
    }


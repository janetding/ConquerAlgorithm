package ADT;

/**
 * Created by janet1 on 5/29/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    private static int size = 0;

    public int size(){
        return size();
    }
    public ListNode(int x) { val = x; }

    public static ListNode build(int[] arr){
        size = arr.length;
        return null;
    }
}

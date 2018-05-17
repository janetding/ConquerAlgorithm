package binarySearch;

/**
 * Created by janet1 on 5/17/18.
 */
public class HIndexIIL275 {
    public static int hIndex(int[] citations){
        int n = citations.length; int l = 0, r = n-1, i =0; int m;
        while (l <= r){
            m = l + (r-l)/2;
            if(citations[m] == n - m) return citations[m];
            else if(citations[m] > n-m) r = m-1;
            else l = m+1;
        }
        return n-l;
    }

    public static void main(String[] args) {
        int[] citations = {0,2,4,6,8};
        System.out.println("his h-index is  " + hIndex(citations));
    }
}

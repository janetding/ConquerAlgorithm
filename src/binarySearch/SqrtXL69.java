package binarySearch;

/**
 * Created by janet1 on 5/16/18.
 */
public class SqrtXL69 {
    public static int  mySqrt(int x){
        //base case
        if (x == 0) return 0;
        int start =1, end = Integer.MAX_VALUE; int mid;
        while (true){
            mid = start  + (end - start)/2;
            if(mid > x/mid) end = mid +1;
            else {
                //if mid^2 > x; then (mid+1)^2 = mid ^2 + 2xmid +1 > x
                if ( (mid + 1) > x/mid)
                    return mid;
                else
                    start = mid -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }
}

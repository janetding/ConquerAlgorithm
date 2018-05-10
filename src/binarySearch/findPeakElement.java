package binarySearch;

/**
 * Created by janet1 on 5/10/18.
 */
public class findPeakElement {
    public static int findPeakElementOne(int nums[]) {
        if ( nums == null && nums.length == 0 ) return 0;
        int n = nums.length;
        int start = 0, end = n - 1 ;
        while ( start + 1 < end ){
        int mid = start + ( end - start ) / 2;
        int pre = Math.max(0,mid - 1);
        int post = Math.min( n , mid + 1);
        if ( nums[mid] > nums[post] && nums[mid] > nums[pre] ) return mid;
        else if ( nums[mid] > nums[pre] && nums[mid] < nums[post]) start = mid;
        else end = mid;
    }
        if ( nums[start] > nums[end] ) return start;
        return end;
}

    public static void main(String[] args) {
        /* Driver program to test above function */
        int nums[]  = {5, 9,7, 8};
        findPeakElement  fb = new findPeakElement ();
        int n = nums.length;
        int index = fb.findPeakElementOne (nums);
        if(index == -1) System.out.println("Not find");
        else System.out.println("The peak element at the index number: " + index);
    }
}
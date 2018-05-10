package binarySearch;

/**
 * Created by janet1 on 5/10/18.
 */
public class findPeakElement {
    public static int findPeakElementProb(int[] nums, int n) {
        //corner case
        if (nums == null || nums.length == 0) return -1;
        int start = 0; n = nums.length;
        int end = n - 1, mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            int pre = Math.max(0, mid - 1);
            int post = Math.min(mid + 1, n);
            if (nums[mid] > nums[pre] && nums[mid] > nums[post]) return mid;
            else if (nums[mid] > nums[pre] && nums[mid] < nums[post]) start = mid + 1;
            else end = mid - 1;
        }
        if (nums[start] > nums[end]) return start;
        return end;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10,4};
        int n,key;
        n = arr.length;
        System.out.println("Index: " + findPeakElementProb(arr,n) );
    }
}



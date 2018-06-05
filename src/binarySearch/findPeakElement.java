package binarySearch;

/**
 * Created by janet1 on 5/10/18.
 */
public class findPeakElement {

        public static int findPeakElementProb(int[] nums) {
            //corner case
            if ( nums == null || nums.length == 0) return -1;
            int start = 0; int end =nums.length -1; int mid;
            while(start + 1 < end) {
                mid = start + ((end - start) >> 1);
                if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
                    return mid;
                }else if(nums[mid] < nums[mid +1] && nums[mid] > nums[mid-1]){
                    start = mid;
                }else{
                    end = mid;
                }

            }
            return nums[start] > nums[end] ? start : end;
        }




    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10,4};
//        int n,key;
//        n = arr.length;
        System.out.println("Index: " + findPeakElementProb(arr) );
    }
}



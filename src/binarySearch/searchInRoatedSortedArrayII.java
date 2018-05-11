package binarySearch;

/**
 * Created by janet1 on 5/10/18.
 */
public class searchInRoatedSortedArrayII {
    public static boolean search(int[] nums, int target) {

         if ( nums == null || nums.length == 0) return false;
         int start = 0, end = nums.length,mid;
         while ( start < end ){
             mid = start + (( end - start ) >>1);
             if ( nums[mid] == target ) return true;
             if ( nums[mid] > nums[start] ){
                 if ( target < nums[start] || target > nums[mid] ) start = mid + 1;
                 else end = mid;
             }else{
                 if ( target <= nums[end - 1] && nums[mid] < target) start = mid + 1;
                 else end = mid;
             }
         }
         return false;}

        public static boolean search2(int[] nums, int target) {
        int left = 0, right = nums.length-1; int mid;
        while(left<=right){
            mid = left + ((right - left) >> 1);
            if(nums[mid] == target)
                return true;
            /**if the left and right section in the left part is equal, cannot recognize which part is sorted*/
            else if(nums[left] == nums[mid]) left++;
            /**left part is sorted */
            else if(nums[left] < nums[mid]){
                /**if target is in the sorted left range*/
                if(nums[left] <= target && target < nums[mid]) right = mid-1;
                else  left = mid + 1;
                /**right part is sorted */
            }else {
                /**if target is in the sorted right range*/
                if(nums[mid] < target && target <= nums[right] ) left= mid +1;
                else right = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arrays = {2,5,6,0,0,1,2};
        int key1 = 3;
        System.out.println( search(arrays, key1));
        int key2 = 0;
        System.out.println( search(arrays, key2));
    }
}



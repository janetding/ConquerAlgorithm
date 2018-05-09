package binarySearch;

/**
 * Created by janet1 on 5/9/18.
 */
public class searchInsertProblem {

       private static int searchInsert(int[] nums, int i, int n, int target) {
            //corner case
            int start = 0, end = nums.length ; int mid = 0;
            if(nums == null || nums.length == 0) return -1;

            while (start < end){
                mid = start + ((end - start) >> 1);
                if (nums[mid] == target)   return mid;
                if (nums[mid] > target) end = mid;
                else start = mid +1;
            }
            return start;
        }

    public static void main(String[] args) {


        /* Driver program to test above function */

            int arr[] = {2, 4, 6, 8, 10};
            int n,key;
            n = arr.length;
            key = 15;

            System.out.println("Index: " + searchInsert(arr,0, n, key) );
        }
    }







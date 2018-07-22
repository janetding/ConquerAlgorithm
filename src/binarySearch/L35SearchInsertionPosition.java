package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
public class L35SearchInsertionPosition {

    // L35 search insertion position.(Smallest larger position)
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Example 1:
Input: [1,3,5,6], 5
Output: 2
*/
//需要clarify在相等的时候，是insert 在那个位置，以及在有重复的时候，放在哪个位置
    //public int searchInsert(int[] nums, int target) {
        public int searchInsert ( int[] nums, int target){
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            if (target > nums[right]) {//把这个当作corner case处理
                return right + 1;
            }
            if (target < nums[left]) {
                return left;
            }
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

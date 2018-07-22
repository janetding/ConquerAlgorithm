package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */


  //  L34 search for a range
/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
class L34SearchARange{
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = leftPos(nums, target);
        int right = rightPos(nums, target);
        return new int[]{left, right};
    }
    private int leftPos(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (left == nums.length || nums[left] != target) ? -1 : left;
    }
    private int rightPos(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (right < 0 || nums[right] != target) ? -1 : right;
    }
}

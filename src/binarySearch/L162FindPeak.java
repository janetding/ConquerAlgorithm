package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
public class L162FindPeak {

   // L162 Find peak valley element
/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/
public int findPeakElementTwo(int[] nums) {
        if(nums.length == 1) return 0;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        if(nums[len-1] > nums[len-2]) return len-1;
        if(nums[0] > nums[1]) return 0;
        while(left <= right){
        mid = left + (right - left)/2;
        if(mid + 1 <= len){
        if(nums[mid] < nums[mid+1]){
        left = mid + 1;
        }else{
        right = mid - 1;
        }
        }
        }
        return left;
        }
        }

//或者

public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left +1 < right){
        mid = left+(right-left)/2;
        if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
        return mid;
        }
        if(nums[mid]>nums[mid-1]){
        left = mid;
        }
        if(nums[mid]<nums[mid-1]){
        right = mid;
        }
        }
        return nums[left]>nums[right]?left:right;
        }
}

package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by janet1 on 5/11/18.
 */
class findMinimumInRotatedSortedArrayLC153 {
    public int findMin(int[] nums) {


        int left = 0, right = nums.length-1; int mid;
        while (left + 1 < right){
            mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right])  right = mid;
            else if (nums[mid] > nums[right])   left = mid;
            else right --;
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}


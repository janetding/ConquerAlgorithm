package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by janet1 on 5/20/18.
 */
public class IntersectionOfTwoArraysL349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
            Arrays.sort(nums2);
            for (Integer num : nums1) {
                if ( verify(nums2, num)) {
                    set.add(num);
                }
            }
            int i = 0;
            int[] result = new int[set.size()];
            for (Integer num : set) {
                result[i++] = num;
            }
            return result;
        }

    private static boolean verify(int[] nums, Integer target) {
        int left =0, right = nums.length-1;int mid;
        while (left <= right){
            mid = left + (right-left)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) right = mid -1;
            else left = mid +1;
    }
    return false;
    }

    public static void main(String[] args) {
        int[] numOne = {1, 2, 2, 1};
        int[] numTwo = {2, 2};

        System.out.println(Arrays.toString(intersection(numOne, numTwo)));
    }
}


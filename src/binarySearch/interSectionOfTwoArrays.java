package binarySearch;

import java.util.*;

/**
 * Created by janet1 on 5/20/18.
 */
public class interSectionOfTwoArrays {
    public static int[] interSection(int[] numsOne, int[] numsTwo) {
      /** hash set make unique elements, so it can be adopted on the interSectionOfTwoArray with no duplicated one */
//        Set<Integer> set = new HashSet<>();

        List<Integer> set = new ArrayList<>();
        for (Integer num : numsOne) {

            if (binarySearch(numsTwo, num)) {
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

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0 , right = nums.length-1; int mid;
        while (left <= right){
            mid = left + (right - left )/2;
            if (nums[mid] == target) return true;
            else if(nums[mid] > target) right = mid -1;
            else left = mid -1;
        }
        return false;
    }

    public static void main(String[] args) {


        int[] numOne = {1, 2, 2, 1};
        int[] numTwo = {2, 2};

        System.out.println(Arrays.toString(interSection(numOne, numTwo)));
    }

}

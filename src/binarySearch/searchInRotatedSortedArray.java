package binarySearch;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by janet1 on 5/10/18.
 */
public class searchInRotatedSortedArray {

    //TreeMap, easy to follow
    private static int search(int[] nums, int target) {
        TreeMap<Integer, Stack> tree = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!tree.containsKey(nums[i])) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                tree.put(nums[i], stack);
            } else {
                tree.get(nums[i]).push(i);
            }
        }
        if (tree.containsKey(target)) {
           return  (int) tree.get(target).peek();
        } else {
            return -1;
        }
    }
    //BST time efficient
    private static int search2(int[] nums,  int target) {
        if ( nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length,mid;
        while ( start < end ){
            mid = start + ( end - start ) / 2;
            if ( nums[mid] == target ) return mid;
            if ( nums[mid] > nums[start] ){
                if ( target < nums[start] || target > nums[mid] ) start = mid + 1;
                else end = mid;
            }else{
                if ( target <= nums[end - 1] && nums[mid] < target) start = mid + 1;
                else end = mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arrays = {4,5,6,7,0,1,2};
        int key = 3;
        System.out.printf("Index: %d%n", search(arrays,  key));
        int key2 = 6;
        System.out.printf("Index: %d%n", search2(arrays, key2));
    }
}

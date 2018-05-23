package binarySearch;

import java.util.Arrays;
//Assume that there is only one duplicate number, find the duplicate one

public class findTheDuplicateNumber {
    public static int findDuplicate(int[] num) {
        Arrays.sort(num);
        //bruce force,  便利一遍，只要sort过了，那就是in order的
        //eg, {1,2,2,4,5} 2&2是并排站的
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] == num[i + 1]) return num[i];
        }
        return -1;
    }
//        Arrays.sort(num);
//        //linked list head =0;
//        int left = 1, right = num.length - 1;
//        int mid =0;
//        while (left <= right) {
//            mid = left + (right - left) / 2;
//            int count = 0;
//            for (int i : num) {
//                if (i <= mid) count += 1;
//            }
//            if (count <= mid) left = mid + 1;
//            else right = mid-1;
//
//        }
//        return left;








    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 4, 5};
        int[] numTwo = { 1,2,4,3,3};
        System.out.println(Arrays.toString(new int[]{findDuplicate(num1)}));
        System.out.println(Arrays.toString(new int[]{findDuplicate(numTwo)}));
    }
}







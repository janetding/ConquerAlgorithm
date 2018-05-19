package binarySearch;

import java.util.Arrays;

/**
 * Created by janet1 on 5/18/18.
 */
class twoSumL167 {
    public static int[] twoSum(int[] numbers, int target) {

        int l =0, h = numbers.length - 1;
        int[] res = new int[2];
        while(l <= h){
            int temp = numbers[l] + numbers[h];
            if (temp == target) {
                res[0] = l + 1;
                res[1] = h + 1;
                return res;
            }

            else if (temp > target){
                h--;
            }else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};

        System.out.printf("The sum of 2 and 7 is 9. Therefore index1 , index2: %s%n", Arrays.toString(twoSum(arr, 9)));
    }
}

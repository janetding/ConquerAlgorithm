package Array;

import java.util.Arrays;

/**
 * Created by janet1 on 6/23/18.
 */
 class arrayPartitionI {
    public static int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int result =0;
        for (int i = 0; i < nums.length ; i += 2) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numTwo = {1,4,3,2};
        arrayPartitionI ap = new arrayPartitionI();
        System.out.println(ap.arrayPairSum(numTwo));
    }
}

package Array;

import java.util.Arrays;

/**
 * Created by janet1 on 7/4/18.
 */
public class moveZeroes {
    public static int[] moveZero(int[] nums){
      //corner case
        if(nums == null || nums.length == 0) return nums;
        int insertIndex = 0;
        //insert num, if that num is not equal to 0
        for (int num : nums){
            //u cannot use while, as it is not controlled by for
            if (num != 0){
                nums[insertIndex++] = num;
            }
        }
        //judge if nums.length < insertIndex;  then add 0 at the end
        while (insertIndex < nums.length){
            nums[insertIndex++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] numAll = {0,1,0,3,12};
        System.out.print(Arrays.toString(moveZero(numAll)));
    }

}

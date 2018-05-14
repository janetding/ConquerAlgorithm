package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by janet1 on 5/12/18.
 */
public class jumpGameL45 {
    public int jump(int[] nums) {
//        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
//        int[] dp = new int[nums.length];
//        dp[nums.length - 1] = 0;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            // set to integer max
//            dp[i] = Integer.MAX_VALUE;
//            for (int j = i + 1; j <= i + nums[i]; j++) {
//                if (j < nums.length && dp[j] != Integer.MAX_VALUE) {
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//
//        return dp[0];

//similar like L55, jumpGame
            int sc = 0;
            int e = 0;
            int maxRange = 0;
            for(int i=0; i<nums.length-1; i++) {
                maxRange = Math.max(maxRange, i+nums[i]);
                if( i == e ) {
                    sc++;
                    e = maxRange;
                }
            }
            return sc;
        }



    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new jumpGameL45().jump(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

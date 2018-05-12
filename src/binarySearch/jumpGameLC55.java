package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by janet1 on 5/12/18.
 */
public class jumpGameLC55 {
    public boolean canJump(int[] nums){
       int maxRange = 0;
        for (int i = 0; i <= maxRange ; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (maxRange >= nums.length-1)
                return true;
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            boolean ret = new  jumpGameLC55().canJump(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

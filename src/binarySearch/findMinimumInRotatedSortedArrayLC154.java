package binarySearch;

/**
 * Created by janet1 on 5/12/18.
 */





        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

/**
 * Created by janet1 on 5/11/18.
 * Same solution to LC153
 */
public class findMinimumInRotatedSortedArrayLC154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) right = mid;
            else if (nums[mid] > nums[right]) left = mid;
            else right--;
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
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

            int ret = new findMinimumInRotatedSortedArrayLC154().findMin(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

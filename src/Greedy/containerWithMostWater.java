package Greedy;

/**
 * Created by janet1 on 6/10/18.
 * time complexity is arr.length - 1;
 */
public class containerWithMostWater {
    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int result = Integer.MIN_VALUE;
        while (left < right) {
            area = Math.min(height[right], height[left]) * (right - left);
            result = Math.max(result, area);

            if (height[left] < height[right]) left++;
            else right--;
        }
    return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7};
        System.out.println(maxArea(arr));
    }
}

package Greedy;

/**
 * Created by janet1 on 6/10/18.
 */
public class containerWithMostWater {
   private static int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int area ;
        int result = Integer.MIN_VALUE; // initialize result w/ Integer.MIN_VALUE;

        while (start < end) {
            //heights should choose the min, Math.min(heights[end] , heights[start])
            // as you are not sure, height[end] or height[start], which one is min
            area = Math.min(heights[end], heights[start]) * (end - start);
            result = Math.max(result, area);
            if (heights[start] <= heights[end]) {
                start++;
            } else {
                //heights[start] > heights[end]
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        System.out.println(maxArea(arr));
    }
}

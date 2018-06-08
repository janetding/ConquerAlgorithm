package binarySearch;
package binarySearch;

import java.util.ArrayList;

/**
 * Created by janet1 on 6/6/18.
 */
public class findValleyTwo {
    public static void main(String[] args) {
        int[] heights = {2, 1, 4, 5, 3, 7};
        ArrayList<Integer> valleys = findValley (heights);
        System.out.println("The valleys are at " + valleys);
    }


    private static ArrayList<Integer> findValley(int[] heights) {
        if (heights == null || heights.length == 0 ) return null;

        ArrayList<Integer> valleys = new ArrayList<>();
        int valley =0;
        for (int i = 0; i < heights.length ; i++) {
            //at the beginning position; ascending order
            if(i == 0 && heights[i] < heights[i+1]) valleys.add(i-1);
            // at the last position; descending order
            if(i == heights.length-1 && heights[i-1] > heights[i]) valleys.add(i);
            //normal situation
            if (i != 0 && i!= heights.length-1){
                if (heights[i-1] > heights[i] && heights[i] < heights[i+1]) valleys.add(i);
            }
        }
        return valleys;
        }
    }

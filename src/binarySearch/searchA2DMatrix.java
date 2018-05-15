package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import static binarySearch.jumpGameLC55.booleanToString;

/**
 * Created by janet1 on 5/14/18.
 */
public class searchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
//corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1; // nums is more than index

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int i = mid / cols;
            int j = mid % cols;

            if (matrix[i][j] < target) start = mid + 1;
            else if (matrix[i][j] > target) end = mid - 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix, 10));
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}





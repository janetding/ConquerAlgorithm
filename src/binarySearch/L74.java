package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
public class L74 {

    //  L74 search int a 2D matrix
/*
   [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

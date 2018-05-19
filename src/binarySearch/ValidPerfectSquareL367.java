package binarySearch;

/**
 * Created by janet1 on 5/18/18.
 */
public class ValidPerfectSquareL367 {
    public static boolean isPerfectSquare(int num){
       int left = 1, right = num; long mid;
        while (left <= right){
            mid = left + ((right - left) >> 2);
            if(mid*mid == num) return true;
            if (mid*mid < num) left = (int)mid +1;
            if (mid*mid > num) right = (int)mid -1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(9));

    }
}

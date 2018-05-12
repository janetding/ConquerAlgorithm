package binarySearch;

/**
 * Created by janet1 on 5/12/18.
 */
public class powxnLC50 {
    public double myPow(double x, int n){
        if (n == Integer.MIN_VALUE){
            double half = myPow(x, n >> 1);
            return half * half;
        }
        if (n < 0) return 1/myPow(x, -n);
        if (n == 0) return 1;
        if (x == 0) return 0;
        double half = myPow(x, n >> 1);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}



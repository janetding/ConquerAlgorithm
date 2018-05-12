package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            double x = Double.parseDouble(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            double ret = new powxnLC50().myPow(x, n);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}
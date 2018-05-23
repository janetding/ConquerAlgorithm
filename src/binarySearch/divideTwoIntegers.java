package binarySearch;

/**
 * Created by janet1 on 5/21/18.
 */
public class divideTwoIntegers {
public int divide(int dividend, int divisor) {
    if (dividend == -2147483648){
        if (divisor == -1){
            return Integer.MAX_VALUE;
        }
    }


    int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
  dividend = Math.abs(dividend);
divisor = Math.abs(divisor);
    int quotient =0;
    while (dividend >= divisor) {

        dividend -= divisor;
        quotient++;
    }

    return sign * quotient;
}
    public static void main(String[] args) {

        divideTwoIntegers d=new divideTwoIntegers();
        System.out.println(d.divide(7, -3));
        System.out.println(d.divide(-2147483648 , -1));
        }
    }


package Practise;

import java.util.Scanner;

/**
 * Created by janet1 on 9/1/18.
 */
public class AddTwoDecimal0901ForLoop {
    public static void main(String[] args) {
        System.out.println("First decimal: ");
        String inputOne = new Scanner(System.in).nextLine();
        System.out.println("Second decimal: ");
        String inputTwo = new Scanner(System.in).nextLine();
        System.out.println("Sum of two binary number is : " + sum(inputOne, inputTwo) );
    }

    public static String sum(String b1, String b2){
        int len1 = b1.length();
        int len2 = b2.length();
        int carry = 0;
        String res = " ";

        //final lengthof the result depends on bigger length between a and b
        //also value of carry, if carry = 1; add "1" at the head of result
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            //starting from last char of String b1 and b2
            //left side is an int and right side is char
            //so we need to minus the decimal value of '0'
            int p = i < len1 ? b1.charAt( len1 - 1 - i ) - '0' : 0;
            int q = i < len2 ? b2.charAt( len2 - 1 - i ) - '0' : 0;
            int temp = p + q + carry;
            res = temp % 2 + res;
            carry = temp / 2;
        }
        return ( carry == 1 ) ?  "1" + res : res;
    }
}

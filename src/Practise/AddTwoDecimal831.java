package Practise;

import java.util.Scanner;

/**
 * Created by janet1 on 8/31/18.
 */
public class AddTwoDecimal831 {
        // This function adds two
        // binary strings and return
        // result as a third string
        static String addBinary(String a, String b)
        {

            // Initialize result
            String result = "";

            // Initialize digit sum
            int s = 0;

            // Travers both strings starting
            // from last characters
            int i = a.length() - 1, j = b.length() - 1;
            while (i >= 0 || j >= 0 || s == 1)
            {

                // Comput sum of last
                // digits and carry
                s += ((i >= 0)? a.charAt(i) - '0': 0);
                s += ((j >= 0)? b.charAt(j) - '0': 0);

                // If current digit sum is
                // 1 or 3, add 1 to result
                result = (char)(s % 2 + '0') + result;

                // Compute carry
                s /= 2;

                // Move to next digits
                i--; j--;
            }

            return result;
        }
        //Drive code
        public static void main(String args[])
        {
//            String a = "1101" ;

            System.out.println("Enter 1st decimal : " );
            String a = new Scanner(System.in).next();
            System.out.println("Enter 2nd decimal : " );
            String b = new Scanner(System.in).next();
            System.out.println("Final sum: " );
            System.out.print(addBinary(a, b));
        }
    }



package Practise;

import java.util.Scanner;

/**
 * Created by janet1 on 9/1/18.
 */
public class AddTwoDecimalRevised {
    static String addBinary(String a, String b){
        //initialize the string
        String result = " ";

        //intialize the digit sum
        int s = 0;

        //start from last digit
        int i = a.length() - 1 ;  int j = b.length() - 1 ;

        while ( i >= 0 || j >= 0 || s == 1){
            //computer sum of last digits and carry
            s += (( i >= 0 ) ? a.charAt( i ) - '0' : 0 );
            s += (( j >= 0 ) ? b.charAt( j ) - '0' : 0 );

            result = (char) ( s % 2  + '0') + result;

            //computer carry
            s /= 2;

            //move to the next digit
            i--; j--;
        }
        return result;
    }


    public static void main(String[] args) {
//        String a = "1101", b="100";
//        System.out.println();
//        System.out.print(addBinary(a, b));
        System.out.println("Please enter first binary number");
        String inputOne = new Scanner(System.in).nextLine();
//        String first = scnr.nextLine();

        System.out.println("Please enter second binary number");
        String inputTwo = new Scanner(System.in).nextLine();
//        String second = scnr.nextLine();

        System.out.println("Sum up : " + addBinary(inputOne, inputTwo));
        }
    }


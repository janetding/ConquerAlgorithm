package binarySearch;
import java.util.Scanner;

/**
 * Created by janet1 on 5/9/18.
 */
public class guessNumber{
    private static int guessNumbers(int input){
        int guess = 1;

        int left = 0, right;

        while (guess < input){

            if (guess < input){
                left = guess;
                guess *= 2;
            }
        }
        right = guess;
        return myBinarySearch(input,left,right);
    }

    private static int myBinarySearch(int input, int left, int right) {
        int mid = 0;

        while (left < right){
            mid = left + (right - left) / 2;

            if(mid == input) return mid;
            if(mid < input) left = mid;
            else right = mid;
        }

        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter an integer.");
        int input = sc.nextInt();

        System.out.println("Input number is: " + input);

        int guessedNum = guessNumbers(input);
        System.out.println("The guessed number is: " + guessedNum);

        if(input == guessNumbers(input)){
            System.out.println("Guess correct!");
        }else {
            System.out.println("Wrong guess.");
        }

        }
    }

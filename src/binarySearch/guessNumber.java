package binarySearch;
import java.util.Scanner;

/**
 * Created by janet1 on 5/9/18.
 */
public class guessNumber{
    private static int guessNumbers(int n){
        int start = 1, end = n, mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (guessNumbers(mid) == 0) return mid;
            if (guessNumbers(mid) == 1) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Original number: " );
        int number =sc.nextInt();
        System.out.println("Guessing number: ");
        int guess = sc.nextInt();
            //check
            if (guess < number) System.out.println("Too low, try again!");
            else if (guess > number) System.out.println("Too high, try again!");
            else System.out.println("Big congratulations, you got it!");

        }
    }

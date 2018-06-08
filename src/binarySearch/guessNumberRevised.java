package binarySearch;

/**
 * Created by janet1 on 6/6/18.
 * The guess API is defined in the parent class GuessGame.
 * @ -1 if my number is lower, 1 if my number is higher, otherwise return 0
 int guess(int num);
 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 */



public class guessNumberRevised {
    public int guessNumber(int n) {
        //start cannot be 0; otherwise will be no sense
        int start = 1;
        int end = n;
        int mid =0;
        while (start +1 < end) {
            if (guess(mid) == 0) return mid;
                //myNumber is higher ==> computer number is higher than my guessing, so user needs to increase
            else if (guess(mid) == 1) start = mid + 1;
            else end = mid - 1;

        }
        return start ;
    }

    private  int guess(int num) {
        //myNumber is computer's number ,
        int myNumber =5;
        if (myNumber == num) {
            return 0;
        }
        //user's guessing number
        else if (myNumber > num) {
            return 1;

        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        guessNumberRevised  binarySearch = new guessNumberRevised ();
        System.out.println(binarySearch.guess(4));
    }
}

package binarySearch;

/**
 * Created by janet1 on 5/17/18.
 */
public class LongestIncreasingSubsequenceL300 {
    public static int lengthOfIs(int [] nums){
        int size =0, m;
        int[] tails = new int[nums.length ];
        for (int x:  nums) {
            int i = 0; int j = size;
            while (i != j){
                m = i + (j-i)/2;
                if (tails[m] < x ) i = m+1;
                else
                    j = m;
            }
            tails[i] = x;
            if( i == size) size ++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = { 10,9,2,5,3,7,101,18};

        System.out.println("The length is : " +lengthOfIs(nums));
    }
}

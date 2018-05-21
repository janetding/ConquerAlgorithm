package binarySearch;

import java.util.Arrays;

public class findTheDuplicateNumber {
    public static int findDuplicate(int[] num) {
//        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] == num[i + 1]) return num[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 4, 5};
        int[] numTwo = { 2,4, 6, 6};
        System.out.println(Arrays.toString(new int[]{findDuplicate(num1)}));
        System.out.println(Arrays.toString(new int[]{findDuplicate(numTwo)}));
    }
}







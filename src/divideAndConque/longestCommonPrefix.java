package divideAndConque;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by janet1 on 6/8/18.
 */
public class longestCommonPrefix {
    public String findLongestCommonPrefix(String[] strs){

        if( strs == null || strs.length == 0) return "";
        //define the boundary
        return findLongestCommonPrefix(strs, 0, strs.length-1);
    }

    private String findLongestCommonPrefix(String[] strs, int l, int r) {
        // left parts and right parts are equal, optimal situation
        if(l == r) {
            return strs[l];
        }
        else{
            int mid = l + (r - l)/2;
            String lcpLeft = findLongestCommonPrefix(strs, l,mid-1);
            String rcpLeft = findLongestCommonPrefix(strs, mid+1, l);
            return commonPrefix(lcpLeft, rcpLeft);
        }
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min ; i++) {
            if(left.charAt(i) != right.charAt(i))
                return left.substring(0,i);

        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
       String arr1 = "geeks";
        String arr2 = "ge";
        System.out.println(commonPrefix(arr1, arr2));
    }
}

package Greedy;

import java.util.Set;
import java.util.HashSet;


/**
 * Created by janet1 on 6/10/18.
 * Using sliding window concept
 * Two points, i & j comes from left to right together; ++
 * HashSet only contains unique number, finally, use i pointer to remove duplicated char
 *
 */
public class longestSubStringNoDuplicated {
    public static int lengthOfLongestSubstring(String s){
        int res =0; int left=0; int right =0;
        Set<Character> st = new HashSet<Character>();
        while (right < s.length()){
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right++));
                res = Math.max(res, st.size());
            }else{
                st.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String one = "abcdabcbb";
        System.out.println(lengthOfLongestSubstring(one));
    }
}

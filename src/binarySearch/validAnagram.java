package binarySearch;

import java.util.Arrays;
import java.util.HashMap;

class validAnagram {

    // sorting two strings, time complexity n*log(n)
    public static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    // hashmap
//    public static boolean isAnagram2(String s, String t) {
//
//        if (s.length() != t.length()) return false;
//
//        HashMap<Character, Integer> map1 = toHashMap(s);
//        HashMap<Character, Integer> map2 = toHashMap(t);
//
//        for (int i = 0; i < s.length(); i++) {
//            char temp = s.charAt(i);
//
//
//        }
//
//    }

//    private static HashMap<Character,Integer> toHashMap(String s) {
//    }


    public static void main(String[] args) {
       String s1 = "anagramhh";
       String s2 = "nagaramh";


//       boolean isAnagram = isAnagram(s1,s2);
//
//        System.out.println(isAnagram);

        System.out.println(isAnagram1(s1,s2));

        System.out.println(s1);
        System.out.println(s2);







//       char[] ch1 = s1.toCharArray() ;
//       char[] ch2 = s2.toCharArray();
//       Arrays.sort (ch1);
//       Arrays.sort (ch2);
//
//       for (int i = 0; i < ch1.length; i++) {
//            if(ch1[i] != ch2[i])
//                System.out.println(false);
//            break;
//        }
//
//        System.out.println(true);
    }
}
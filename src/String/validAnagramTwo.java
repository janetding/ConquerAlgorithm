package String;

/**
 * Created by janet1 on 5/23/18.
 */
public class validAnagramTwo {
    public static boolean validAnagram(String s, String t) {
        //corner case
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "aa";
        String s3 = "nagaram";

        System.out.println(validAnagram(s1, s3));
        System.out.println(validAnagram(s1, s2));

//        System.out.println(new String.validAnagram(s1, s3));

    }
}





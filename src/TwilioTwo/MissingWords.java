package TwilioTwo;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {

    public static void main(String[] args) {
        String s = "I love java coding challenge";
        String t = "I love coding";



        List<String> res = missionWords(s, t);
        System.out.println(res);
    }

    private static List<String> missionWords(String s, String t){
        List<String> res = new ArrayList<>();

        if (s == null || t == null) return res;

        int i = 0, j = 0;

        String[] S = s.split(" ");
        String[] T = t.split(" ");

        while (i < S.length && j < T.length){
            String frS = S[i];
            String frT = T[j];

            if (frS.equals(frT)){
                i++;
                j++;
            }else {
                res.add(frS);
                i++;
            }
        }

        while (i < S.length){
            res.add(S[i++]);
        }

        return res;

    }
}

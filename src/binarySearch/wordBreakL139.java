package binarySearch;


import java.util.List;

/**
 * Created by janet1 on 5/13/18.
 */
public class wordBreakL139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == true && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}

//        boolean[] f = new boolean[s.length() + 1];
//        f[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (f[j] && wordDict.contains(s.substring(j, i))) {
//                    f[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return f[s.length()];
//    }




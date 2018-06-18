package Greedy;

/**
 * Created by janet1 on 6/17/18.
 */
public class AssignCookie {
    public static int findContentChildren(int[] g, int[] s){
        int i = 0;
        for (int j = 0; j < s.length && i < g.length ; j++) {
            if (g[i] <= s[j]) i ++;

        }
        return i;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int[] g1= {1,2};
        int[] s1 = {1,2,3};
        System.out.println(findContentChildren(g,s));
        System.out.println(findContentChildren(g1,s1));
    }
}

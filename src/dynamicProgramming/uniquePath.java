package dynamicProgramming;

/**
 * Created by janet1 on 6/29/18.
 */
public class uniquePath {
    public static int uniquePaths (int m, int n){
        int[][] F = new int[m][n];

        int i, j;

        // row
        for (i = 0; i < m ; i++) {
            //column
            for (j = 0; j < n ; j++) {
                //corner case
                if( i == 0 || j == 0){
                    F[i][j] = 1;
                }else{
                    F[i][j] = F[i-1][j] + F[i][j-1];
                }
            }

        }
        return F[m-1][n-1];
    }

    public static void main(String[] args) {
        int o = 7; int p = 3;
        int s = 3; int t = 2;
        System.out.println(uniquePaths(o, p));
        System.out.println(uniquePaths(s,t));
    }

}

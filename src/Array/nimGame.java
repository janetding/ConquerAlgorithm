package Array;

/**
 * Created by janet1 on 7/4/18.
 */
public class nimGame {
    public static boolean canWinNim(int n){
        return (n % 4 != 0);

    }

    public static void main(String[] args) {
        int m ;
        m = 4;
        System.out.println(canWinNim(m));
    }
}


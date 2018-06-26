package dynamicProgramming;

/**
 * Created by janet1 on 6/25/18.
 */
public class changeCoin {
    public static int coinChange (int[] coin, int amount){
        // set up the length
        int n = coin.length;
        int[] f = new int[amount+1];// 0,1...amount
        f[0] = 0;//initialization
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            //pick up last coin
            for (int j = 0; j < n; j++) {
                if (i >= coin[j] && f[i - coin[j]] != Integer.MAX_VALUE
                        && f[i - coin[j]] + 1 < f[i]) {
                    f[i] = f[i - coin[j]] + 1;
                }
            }
        }
        if(f[amount] == Integer.MAX_VALUE) return -1;
        else{
            return f[amount];
        }
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amounts = 11;
        System.out.println(coinChange(coins, amounts));
    }
}

package Greedy;

/**
 * Created by janet1 on 6/9/18.
 * very similar as the bestTimetoBuySellStockII
 * looking for valley and peak, we can get maxProfit
 */

public class bestTimetoBuySellStock {
    public static int maxProfit(int[] prices) {
        //corner case
        if (prices == null || prices.length < 2) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int formerPrice = prices[0];
            formerPrice = Math.min(formerPrice, prices[i]);
            ans = Math.max(ans, prices[i] - formerPrice);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6,4,3};
        System.out.println(maxProfit(arr));
    }
}








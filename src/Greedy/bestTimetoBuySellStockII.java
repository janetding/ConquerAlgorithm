package Greedy;

/**
 * Created by janet1 on 6/9/18.
 */
public class bestTimetoBuySellStockII {
    //time complexity is o(n); space complexity is O(1)
    //method one
    private static int maxProfit(int[] prices){
        int total = 0;
        for (int i = 0; i <prices.length -1 ; i++) {
            if(prices[i+1] > prices[i])
                 total += prices[i+1] - prices[i];
        }
        return total;
    }

    //method two
    private static int maxProfitTwo(int[] prices){
        int sum = 0;
        for (int i = 1; i < prices.length ; i++) {
            int difference = prices[i] - prices[i-1];
            if (difference > 0) sum += difference;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr1 = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfitTwo(arr1));
    }
}

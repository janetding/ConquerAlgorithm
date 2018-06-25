package dynamicProgramming;

/**
 * Created by janet1 on 6/21/18.
 */

class minCostClimbingStairs {
    private static int minCostClimbingStair(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i -2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] costs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs min = new minCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStair(costs));
    }
}





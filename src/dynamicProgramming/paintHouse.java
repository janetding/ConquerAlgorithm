package dynamicProgramming;

/**
 * Created by janet1 on 6/21/18.
 */

class paintHouse  {
   private static int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;
        for(int i = 1; i < costs.length ; i++){
            for (int color =0; color < 3; color ++){
                costs[i][color] += Math.min(costs[i-1][(color+1) %3], costs[i-1][(color+2) %3]);
            }
        }
        int n = costs.length -1;
        return Math.min(Math.min(costs[n][0],costs[n][1]), costs[n][2]);
    }


    public static void main(String[] args) {
        int[][] cost = {{17,2,17},{16,16,5},{14,3,19}};
        paintHouse ph = new paintHouse();
        System.out.println(ph.minCost(cost));
    }
}

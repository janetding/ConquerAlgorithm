package Array;

/**
 * Created by janet1 on 6/24/18.
 */
public class maxAreaIsland {




    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c) + area(r, c + 1) + area(r, c - 1));
    }

    public int maxAreaOfIsland (int[][] grid){
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans =0;
        for (int r = 0; r < grid.length ; r++) {
            for (int c = 0; c <grid[0].length ; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;



    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid1 = {{0,0,0,0,0,0,0,0}};

        maxAreaIsland ma = new maxAreaIsland();
        System.out.println(ma.maxAreaOfIsland(grid));
        System.out.println(ma.maxAreaOfIsland(grid1));
    }
}
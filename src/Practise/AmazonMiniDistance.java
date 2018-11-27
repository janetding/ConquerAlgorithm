package Practise;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by janet1 on 8/24/18.
 */
public class AmazonMiniDistance {



    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area){
        //corner case
        //...
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        //boolean[][] visited = new boolean[numRows][numColumns];
        area.get(0).set(0, 0);
        //visited[0][0] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dist = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                // if(area.get(cur[0]).get(cur[1]) == 9) return dist;
                for(int[] dir: dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r >= 0 && r < numRows && c >=0 && c < numColumns && area.get(r).get(c) != 0){
                        if(area.get(r).get(c) == 9) return dist + 1;
                        area.get(r).set(c, 0);
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}

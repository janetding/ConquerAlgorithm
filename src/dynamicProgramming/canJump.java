package dynamicProgramming;

/**
 * Created by janet1 on 6/29/18.
 */
public class canJump {
    public static boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }


        int n = stones.length;
        boolean[] f = new boolean[n];
        //initilize
        f[0] = true;

        for (int j = 1; j < n; j++) {
            //previous stone (last jump)
            f[j] = false; // set false first
            for (int i = 0; i < j; i++) {
                if (f[i] && i + stones[i] >= j) {
                    f[j] = true;
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int[] aS = {3, 2, 1, 0, 4};
        System.out.println(canCross(a));
        System.out.println(canCross(aS));
    }
}
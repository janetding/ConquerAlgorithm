package dynamicProgramming;

/**
 * Created by janet1 on 6/23/18.
 */
public class climbStair {

        public static int climbStairs(int n) {
            if(n == 0 || n == 1 || n == 2){return n;}
            int[] mem = new int[n];
            //initialize
            //not step out, this counts as one way
            mem[0] = 1;
            //step one stair, two ways : 1st not walk ;  directly go to 1st step
            mem[1] = 2;
            for(int i = 2; i < n; i++){
                mem[i] = mem[i-1] + mem[i-2];
            }
            return mem[n-1];
        }

    public static void main(String[] args) {
            int nOne = 3;
        climbStair cs = new climbStair();
        System.out.println(cs.climbStairs(nOne));
    }
    }



package binarySearch;

import java.util.Arrays;

/**
 * Created by janet1 on 5/18/18.
 */
public class RussianDollEnvelopesL354 {
    public static int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
        if (n == 0) return 0;

    int[] tails = new int[n];
    int index = 0, len = 0;

        Arrays.sort(envelopes, (env1, env2) ->{
        return env1[0] != env2[0] ? env1[0] - env2[0] : env2[1] - env1[1];
    });

        for (int[] env : envelopes) {
        index = Arrays.binarySearch(tails, 0, len, env[1]);
        if (index < 0) index = ~index;
        tails[index] = env[1];
        if (index == len) len++;
    }

        return len;
}
//bst

    /**
     * if(envelopes==null||envelopes.length==0)
     return 0;

     Arrays.sort(envelopes, (env1, env2)->{
     //         public int compare(int[] a, int[] b){
     //           if (a[0]!=b[0]) return a[0]-b[0]; //ascending order


     //                 return b[1] - a[1]; // descending order
     //             }
     return env1[0] != env2[0] ? env1[0] - env2[0] : env2[1] - env1[1];
     });

     ArrayList<Integer> list = new ArrayList<Integer>();

     for(int i=0; i<envelopes.length; i++){

     if(list.size()==0 || list.get(list.size()-1)<envelopes[i][1])
     list.add(envelopes[i][1]);

     int l=0;
     int r=list.size()-1;

     while(l!=r){
     int m=l+(r-l)/2;
     if(list.get(m)<envelopes[i][1]){
     l=m+1;
     }else{
     r=m;
     }
     }

     list.set(r, envelopes[i][1]);
     }

     return list.size();
     }
     }
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        for (int[] x : envelopes) {
            System.out.println(Arrays.toString(x));
        }

        System.out.println("The maximum number of envelopes: " + maxEnvelopes(envelopes));
}}

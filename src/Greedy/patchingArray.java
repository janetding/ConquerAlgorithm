package Greedy;

/**
 * Created by janet1 on 6/16/18.
 */
public class patchingArray {
    public static int minPatches (int[]nums, int n){
        long miss = 1; int i = 0, patches = 0;
        while (miss <= n){
            //miss in the range
            if ( i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            }
            else{
                patches ++;
                miss += miss;

            }
        }
        return patches ;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int n = 6;
        int[] nums2 = {1,5,10};
        int n2 = 20;
        int[] nums3 = {1,2,2};
        int n3 = 5;
        System.out.println(minPatches(nums, n));
        System.out.println(minPatches(nums2, n2));
        System.out.println(minPatches(nums3, n3));


    }
}

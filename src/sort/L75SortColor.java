package sort;

import java.util.Arrays;

/**
 * Created by janet1 on 8/26/18.
 */
public class L75SortColor {
    public static void sortColors(int[] nums) {
            if(nums == null || nums.length == 0) return;
                int len = nums.length;
                int low = 0, hi = len - 1;
                int RED = 0, WHITE = 1, BLUE = 2;
                for(int i = 0; i < len; i++){
                    //一定要先排BLUE, 即数字大的(放前面的)，在排RED，即数字小的(放后面的)。因为如果跟BLUE换的是RED，
                    // 那么后面还有一个while可以处理RED。
                    // 用while 是为了防止换回来的数又是相同的，所以用while  接着换，直到不是BLUE为止，因为hi是--的，所以后面的总会碰到不是BLUE的
                    // i < hi 保证 不把 排序好的 BLUE 又还回去
                    while(nums[i] == BLUE && i < hi){
                        swap(nums, i, hi--);
                    }
                    //如果把RED放后面，跟RED（0）换的是一定只能是1，因为RED是跟前面换，前面的是已经处理好的。所以不会是0，或者2。
                    // i > low 保证 不把 排序好的 RED 又还回去
                    while(nums[i] == RED && i > low){
                        swap(nums, i, low++);
                    }
                }
            }
            private static void swap(int[] nums, int i, int j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {2,0,2,1,1,0};
        int arr_size = arr.length;
        System.out.println("Array before sorting -- ");
        printArray(arr, arr_size);
        sortColors(arr);
        System.out.println("Array after sorting -- " );
        printArray(arr, arr_size);
    }
}

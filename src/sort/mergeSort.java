package sort;

/**
 * Created by janet1 on 5/28/18.
 */
public class mergeSort {
    public void divideAndMerge(int[] arr, int left, int right){
        if (arr == null || arr.length < 2)return;

       int n = right - left +1;
       if (n < 1) return;
       int mid = left + (right - left)/2;
       divideAndMerge(arr, left,mid);
        divideAndMerge(arr, mid+1, right);
        merge(arr, left, mid, right);
        }

    private void merge(int[] arr, int left, int mid, int right) {
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,6, 4, 3,5,7};
        
    }


}

package sort;

/*
 * Created by janet1 on 8/30/18.
 *key part is partition, rest is just primitive divide-and-conquer approach
 partition actually finish the function of sort:	put all value smaller than pivot to left, and larger to right

 algorithm in partition method:	basically a two pointer solution
 point i, j
 difinition:	[left, i] means all elements have value smaller than pivot
 (i, j) means all element have value larger than pivot
 [j, right - 1] means the region to explore
 so i need to be start from left - 1, and once find element <= pivot, move i to right by one place first and than swap the value
 */

class QuickSort {
   /* Quick sort algorithm chooses the mid element as the pivot */
   //Quick sort algorithm which chooses the mid element as the  pivot
   public void quickSort(int[] arr) {
       if (arr == null || arr.length <= 1) return;

       quickSort(arr, 0, arr.length - 1);
   }
    //pi is the index of pivot
    //compared with pivot, divide into two ranges, which is the range of less than pivot or larger than pivot
    private void quickSort(int[] arr, int left, int right) {
        int pi = partition(arr, left, right);

        if (left < pi - 1)
            quickSort(arr, left, pi - 1);

        if (pi < right)
            quickSort(arr, pi, right);
    }

    private int partition(int[] arr, int i, int j) {
        int pivot = arr[i + (j - i) / 2];
        //pay attention, this one is while
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            swap(arr, i++, j--);
        }
        return i;
    }


    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    //utility class
    static void printArray(int[] arr){
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}

    public static void main(String[] args) {
    int[] arr = {6,5,3,7,1};
    int m = arr.length;

    QuickSort ob = new QuickSort();
    ob.quickSort(arr, 0, m-1);
    System.out.println("Sorted Array");
    printArray(arr);
    }
}




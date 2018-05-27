package sort;


import java.util.Arrays;

/**
 * Created by janet1 on 5/26/18.
 */
public class selectionSort {
    public static int[] selectSort(int[] array){
        if(array == null || array.length < 2) return array;
        // no need to reach the last element
        //arr.length is fields vs list.size(), str.length() , call method
        for (int i = 0; i < array.length -1 ; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            swab(array, i, minIndex);
        }
        return array;

    }

    private static int[] swab(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String[] args) {
        int[] array1 = { 4, 0, -3, 5};
        System.out.println(Arrays.toString(selectSort(array1)));
    }
}

package binarySearch;

public class VersionControl {

    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        int target = 48;

//        int index = myBinarySearch1(arr, target);

//        if (index == -1) System.out.println("Not find.");
//        else System.out.println("The index of target " + target + " is " + index);
//
//        System.out.println("Search " + count + " times.");

 int         index = myBinarySearch3(arr, target);
         if (index == -1) System.out.println("Not find.");
         else System.out.println("The index of target " + target + " is " + index);
         System.out.println("Search " + count + " times.");

    }

    private static int myBinarySearch3(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1, mid = 0;


        while(left + 1 < right){
            mid = left + (right - left) / 2;
            count++;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid;
            if(arr[mid] > target) right = mid;
        }

        if (arr[left] == target) return left;
        if (arr[right] == target) return right;

        return -1;

    }

    private static int myBinarySearch1(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1, mid = 0;

        while(left <= right){
            mid = left + (right - left) / 2;

            count++;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid + 1;
            if(arr[mid] > target) right = mid - 1;
        }

        return -1;
    }
}

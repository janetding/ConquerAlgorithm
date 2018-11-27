package sort;


import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.*;

    public class SortingAlgorithm {

        static Random random = new Random(System.currentTimeMillis());
        @Rule
        public TestName testName = new TestName();

        private static int[] generateRandomUnsortedArray(int length,int bound) {
            int[] arr = new int[length];


            for (int i = 0; i < length; i++) {
                arr[i] = random.nextInt() % bound;
            }

            while (isSorted(arr)) {
                randomize(arr);
            }

            return arr;
        }

        private static int[] generateRandomPositiveUnsortedArray(int length,int bound) {
            int[] arr = new int[length];


            for (int i = 0; i < length; i++) {
                arr[i] = random.nextInt(100);
            }

            while (isSorted(arr)) {
                randomize(arr);
            }

            return arr;
        }

        private static void randomize(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int randIndex = random.nextInt(arr.length);

                swap(arr, randIndex, i);
            }
        }


        // Check if an array is sorted
        private static boolean isSorted(int[] arr) {
            if (arr == null || arr.length <= 1) return true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) return false;
            }
            return true;
        }

        //Swap two elements in an array
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        @Test
        public void Test1() {
            System.out.println(testName.getMethodName() + ": Bubble sort.");
            int testTimes = 10;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int[] arr = generateRandomUnsortedArray(5,100);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                bubbleSort(arr);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        private void bubbleSort(int[] arr) {
            if (arr == null || arr.length == 0) return;

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

        @Test
        public void Test2() {
            System.out.println(testName.getMethodName() + ":Selection sort.");
            int testTimes = 2;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int[] arr = generateRandomUnsortedArray(5,100);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                selectionSort(arr);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        // Selection sort with two pointers
        public static void selectionSort(int[] arr) {
            if (arr == null || arr.length <= 1) return;

            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]){
                        minIndex = j;
                    }
                }

                swap(arr,i,minIndex);
            }
        }


        @Test
        public void Test3() {
            System.out.println(testName.getMethodName() + ":Merge sort implemented by using two extra array.");
            int testTimes = 2;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int[] arr = generateRandomUnsortedArray(5,100);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                int[] sortedArr = mergeSortUsingTwoExtraArray(arr);
                System.out.println("After  sorting:" + Arrays.toString(sortedArr) + "\n");

                if (!isSorted(sortedArr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        //Merge sort implemented by two array which space complexity is O(nlogn)
        private int[] mergeSortUsingTwoExtraArray(int[] arr) {
            if (arr == null || arr.length <= 1) return arr;

            int n = arr.length;

            int[] a = new int[n / 2];
            int[] b = new int[n - n / 2];

            for (int i = 0; i < a.length; i++) {
                a[i] = arr[i];
            }

            for (int i = 0; i < b.length; i++) {
                b[i] = arr[i + n / 2];
            }

            return merge(mergeSortUsingTwoExtraArray(a),mergeSortUsingTwoExtraArray(b));
        }


        private int[] merge(int[] a, int[] b) {
            int[] c = new int[a.length + b.length];

            int i = 0, j = 0;

            for (int k = 0; k < c.length; k++) {
                if (i >= a.length) c[k] = b[j++];
                else if (j >= b.length) c[k] = a[i++];
                else if (a[i] <= b[j]) c[k] = a[i++];
                else c[k] = b[j++];
            }

            return c;
        }

        @Test
        public void Test4() {
            System.out.println(testName.getMethodName() + ":Merge sort implemented by one global array.");
            int testTimes = 2;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int[] arr = generateRandomUnsortedArray(5,100);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                mergeSortUsingOneGlobalArray(arr);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        int[] helperArr;  //save the temp clip of element from the input array to optimize space complexity
        //Optimize the space complexity to O(n)
        private void mergeSortUsingOneGlobalArray(int[] arr) {
            if (arr == null || arr.length == 0){
                return;
            }

            helperArr = new int[arr.length];

            divideAndMerge(arr,0,arr.length -1);

        }

        private void divideAndMerge(int[] arr, int left, int right) {
            if (left == right) return;

            int mid = left + (right - left) / 2;
            divideAndMerge(arr,left, mid);
            divideAndMerge(arr,mid + 1, right);

            merge(arr, left,mid,right);

        }

        private void merge(int[] arr, int left, int mid, int right) {
            for (int i = left; i <= right; i++) {
                helperArr[i] = arr[i];
            }

            int i = left;
            int j = mid + 1;
            int k = left;

            while(i <= mid && j <= right){
                if (helperArr[i] <= helperArr[j]) arr[k++] = helperArr[i++];
                else arr[k++] = helperArr[j++];
            }

            while (i <= mid){
                arr[k++] = helperArr[i++];
            }
        }



        @Test
        public void Test5() {
            System.out.println(testName.getMethodName() + ":Quick sort.");
            int testTimes = 2;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int[] arr = generateRandomUnsortedArray(5,100);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                quickSort(arr);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        //Quick sort algorithm which chooses the mid element as the  pivot
        private void quickSort(int[] arr) {
            if (arr == null || arr.length <= 1) return;

            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int left, int right) {
            int index = partition(arr, left, right);

            if (left < index - 1)
                quickSort(arr, left, index - 1);

            if (index < right)
                quickSort(arr, index, right);
        }

        private int partition(int[] arr, int i, int j) {
            int pivot = arr[i + (j - i) / 2];

            while (i <= j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;

                if (i <= j) {
                    swap(arr, i++, j--);
                }
            }
//        System.out.println(Arrays.toString(arr));
            return i;
        }



        /*
        Count sort is a sorting technique based on keys between a specific range. It works by counting the frequency of
        every object appears. Time complexity: O(n)
         */
        @Test
        public void Test6() {
            System.out.println(testName.getMethodName() + ":Count sort.");
            int testTimes = 2;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int length = 10, bound = 100;
                int[] arr = generateRandomUnsortedArray(length,bound);
                System.out.println("Before sorting:" + Arrays.toString(arr));
                countSort(arr,bound);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }
        private void countSort(int[] arr,int bound) {
            int[] frequency = new int[bound * 2];

            for (int i = 0; i < arr.length; i++) {
                frequency[arr[i] + 99] += 1;
            }

            int k = 0;
            for (int i = 0; i < frequency.length; i++) {
                int count = frequency[i];

                for (int j = 0; j < count; j++) {
                    arr[k++] = i - 99;
                }
            }

        }


        /*
        Bucket sor is a sorting algorithm that works by distributing the elements of an array into a number of buckets,
        then sort each bucket individually. The Test7 demonstrate a bucket sort by using an array of ArrayList, then
         use insertion sort when put every element into bucket,
         */
        @Test
        public void Test7() {
            System.out.println(testName.getMethodName() + ":Bucket sort.");
            int testTimes = 100;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int length = 100, bound = 100;
                int[] arr = generateRandomPositiveUnsortedArray(length,bound);
//            int[] arr = {6,2, 7, 89, 50, 46, 11, 44, 16, 41};
                System.out.println("Before sorting:" + Arrays.toString(arr));
                bucketSort(arr,bound);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }


        private void bucketSort(int[] arr,int bound) {
            List<Integer>[] bucket = new ArrayList[bound / 10 ];

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<>();
            }

            for (int i = 0; i < arr.length; i++) {

                int index = (arr[i] ) / 10;

                insertionSort(bucket[index],arr[i]);
            }

            int k = 0;

            for (int i = 0; i < bucket.length; i++) {
                List<Integer> list = bucket[i];

                System.out.println(list);

                if (list != null){
                    for (int n :list) {
                        arr[k++] = n;
                    }
                }

            }
        }

        private void insertionSort(List<Integer> list, int num) {

            if (list.size() == 0){
                list.add(num);
            }else {
                int k = 0;

                while (k < list.size() && list.get(k) <= num){
                    k++;
                }

                list.add(k,num);

            }
        }


        @Test
        public void Test8() {
            System.out.println(testName.getMethodName() + ":Heap sort.");
            int testTimes = 100;
            int failTimes = 0;
            for (int i = 0; i < testTimes; i++) {
                int length = 100, bound = 100;
                int[] arr = generateRandomUnsortedArray(length,bound);
//            int[] arr = {6,2, 7, 89, 50, 46, 11, 44, 16, 41};
                System.out.println("Before sorting:" + Arrays.toString(arr));
                heapSort(arr);
                System.out.println("After  sorting:" + Arrays.toString(arr) + "\n");

                if (!isSorted(arr)) {
                    failTimes++;
                }
            }

            System.out.println("Test times\t" + testTimes );
            System.out.println("Fail times\t" + failTimes + "\n");

        }

        private void heapSort(int[] arr) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int i = 0; i < arr.length; i++) {
                heap.offer(arr[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = heap.poll();
            }
        }

    }



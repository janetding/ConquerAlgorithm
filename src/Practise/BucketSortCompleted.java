package Practise;

import ADT.Pair;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.*;

/**
 * Created by janet1 on 8/22/18.
 */
public class BucketSortCompleted {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void test1() {
        int[] numsOne = {1, 2, 4, 3, 2, 2};
        System.out.println("Before bucket sort:  " + Arrays.toString(numsOne));
        bucketSort(numsOne);
        System.out.println("After bucket sort: " + Arrays.toString(numsOne));
    }

    private void bucketSort(int[] numsOne) {
        int[] bucket = new int[numsOne.length];
        for (int i = 0; i < numsOne.length; i++) {
            int index = numsOne[i];
            bucket[index] += 1;

        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            for (int j = 0; j < count; j++) {
                numsOne[k] = i;
                k++;

            }
        }
    }

    @Test
    public void test2() {
        System.out.println(testName.getMethodName());
        String input = "abbck";
        char[] chars = new char[input.length()];
        int i = 0;
        for (char c : input.toCharArray()) {
            chars[i++] = c;
        }
        System.out.println("before bucketsorting: " + Arrays.toString(chars));
        bucketSort(chars);
        System.out.println("after bucketsorting: " + Arrays.toString(chars));
    }

    private void bucketSort(char[] chars) {
        int[] bucket = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a'; // chars[i]-97
            bucket[index] += 1;

        }
        fill(chars, bucket);

    }

    private void fill(char[] chars, int[] bucket) {
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            for (int j = 0; j < count; j++) {
                chars[k] = (char) (i + 97);
                k++;
            }
        }
    }

    @Test
    public void test3() {
        System.out.println(testName.getMethodName());
        String input = "abbbbcc";
        char[] chars = new char[input.length()];
        int i = 0;
        for (char c : input.toCharArray()
                ) {
            chars[i++] = c;

        }
        System.out.println("Before" + Arrays.toString(chars));
        bucketSortUsingHashMap(chars);
        System.out.println("After" + Arrays.toString(chars));
    }

    private void bucketSortUsingHashMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars
                ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int k = 0;
        for (Character c : map.keySet()
                ) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                chars[k] = c;
                k++;

            }

        }
    }

    @Test
    public void test4() {
        System.out.println(testName.getMethodName());
        String input = "gggdddaa";
        char[] chars = new char[input.length()];
        int i = 0;
        for (Character c : input.toCharArray()
                ) {
            chars[i++] = c;

        }
        System.out.println("Before sort: " + Arrays.toString(chars));
        bucketSortUsingHashMap(chars);
        System.out.println("After sort: " + Arrays.toString(chars));

        int k = 3;
        List<Character> rst = topKFrequent(chars, k);
        System.out.println(rst);
    }

    private List<Character> topKFrequent(char[] chars, int k) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (Integer) o1.value - (Integer) o2.value;
            }
        });
        for (char c : chars
                ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(new Pair(c, map.get(c)));
            } else {
                int curFrequency = map.get(c);
                if (curFrequency > (int) heap.peek().value) {
                    heap.poll();
                    heap.offer(new Pair(c, curFrequency));
                }
            }
        }
        List<Character> rst = new LinkedList<>();
        while (!heap.isEmpty()) {
            rst.add(0, (char) heap.poll().key);//descending order
//            rst.add((char) heap.poll().key);
        }

        return rst;
    }
}




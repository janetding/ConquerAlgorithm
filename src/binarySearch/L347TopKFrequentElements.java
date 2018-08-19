package binarySearch;
import java.util.*;


/**
 * Created by janet1 on 8/18/18.
 * Idea is very straightforward:

 build a counter map that maps a num to its frequency
 build a heap/priority queue that keeps track of k most significant entries
 iterate through the final heap and get the keys

 */
public class L347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //build a counter map that map a num to its frequency
        Map<Integer, Integer> counterMap = new HashMap<>();
        for(int num : nums) {
            int count = counterMap.getOrDefault(num, 0);
            counterMap.put(num, count+1);
        }
        //build a heap/priority queue that keeps track of k most significant entries
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        // iterate through the final heap and get the keys
        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }

    public List<Integer> topKFrequentTwo(int[] nums, int k) {
        //Build a array of list to be buckets with length 1 to sort
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] arrayOne = {1,1, 2,2,3};
        int kOne = 2;
        int[] arrayTwo = {1};
        int kTwo = 1;
        L347TopKFrequentElements frequentElements = new L347TopKFrequentElements();

        System.out.println((frequentElements.topKFrequent(arrayOne,kOne)));
        System.out.println((frequentElements.topKFrequent(arrayTwo,kTwo)));
        System.out.println((frequentElements.topKFrequentTwo(arrayOne,kOne)));
        System.out.println((frequentElements.topKFrequentTwo(arrayTwo,kTwo)));
    }
}

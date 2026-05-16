package arrays.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k){
        int[] ans = new int[k];
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums){
            hMap.put(num, hMap.getOrDefault(num, 0 ) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> hMap.get(n1) - hMap.get(n2));
        for (int n : hMap.keySet()){
            pq.add(n);
            if (pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while (!pq.isEmpty()){
            ans[i++] = pq.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequentElements top = new TopKFrequentElements();
        System.out.println(Arrays.toString(top.topKFrequent(nums, k)));
    }
}

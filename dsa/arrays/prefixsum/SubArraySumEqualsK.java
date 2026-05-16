package arrays.prefixsum;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k){

        int count = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        hMap.put(0, 1);
        int sumEndingHere = 0;
        for (int i = 0; i < nums.length; i++){
             sumEndingHere += nums[i];
             if (hMap.containsKey(sumEndingHere - k)){
                 count += hMap.get(sumEndingHere - k);
             }
            hMap.put(sumEndingHere, hMap.getOrDefault(sumEndingHere, 0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int[] arr = {1, 1, 1};
        int k = 2;
        // int k = 3;
        SubArraySumEqualsK ss = new SubArraySumEqualsK();
        System.out.println(ss.subarraySum(arr, k));
    }
}

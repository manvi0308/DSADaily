package arrays.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // [2, 7, 11, 5]
    // target = 9 --> [0, 1]
    // x + y = z
    // x, and y, I know z
    // are negatives possible?
    // in case of multiple answers, do i need to returnn the valid answer or any is fine
    // range of inputs?

    public int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (hMap.containsKey(complement))
                return new int[]{hMap.get(complement), i};
            hMap.put(nums[i], i);
        }
        return ans;
    }
}

package medium;

import java.util.Arrays;

public class RearrangeElementsBySign {
    /*
    alternate signs i.e. + and -
    order in which they were originally present should be preserved
    Input: nums = [3,1,-2,-5,2,-4]
                     |
                  [3, -2, 1, -5, 2, -4]

     */
    public int[] rearrange(int[] nums){
        int[] res = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res[posIndex] = nums[i];
                posIndex += 2;
            } else{
                res[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        RearrangeElementsBySign obj = new RearrangeElementsBySign();
        int[] res = obj.rearrange(arr);
        System.out.println(Arrays.toString(res));
    }
}

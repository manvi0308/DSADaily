package medium;

import java.util.Arrays;

public class RotateArray {
    // rotate array to right by k steps
    /*
    1, 2, 3, 4, 5, 6, 7
    k = 3

    rotate 1 step
    7, 1, 2, 3, 4, 5, 6
    rotate 2 steps
    6, 7, 1, 2, 3, 4, 5
    rotate 3 steps
    5, 6, 7, 1, 2, 3, 4
     */
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        // 1, 2, 3, 4, 5, 6, 7
        // n = 7, k = 3
        // reverse( nums, 4, 6) --> [1, 2, 3, 4, 7, 6, 5]
        reverse(nums, n - k, n - 1);

        // reverse( nums, 0, 3) -->  [4, 3, 2, 1, 7, 6, 5]
        reverse(nums, 0, n - k - 1);

        // reverse(nums, 0, 6) --> [5, 6, 7, 1, 2, 3, 4]
        reverse(nums, 0, n - 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray ra = new RotateArray();
        ra.rotate(nums, 3);
    }
}

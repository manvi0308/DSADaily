package arrays.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[n];
        suffixProduct[n - 1] = 1;
        for(int i = 1; i < n;i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0;i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < n; i++) {
            res[i] = prefixProduct[i] * suffixProduct[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
        int[] ans = ps.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}

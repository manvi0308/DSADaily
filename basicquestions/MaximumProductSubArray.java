public class MaximumProductSubArray{
    static int maxProduct(int[] nums){
        if (nums.length == 0)
            return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];

        int result = max_so_far;

        for (int i = 1; i < nums.length; i++){
            int curr = nums[i];

            int tempMax = Math.max( curr, Math.max( max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min( curr, Math.min(min_so_far*curr, max_so_far*curr));

            max_so_far = tempMax;
            result = Math.max( result, max_so_far );
        }
        return max_so_far;
    }
    public static void main(String[] args) {

    }
}
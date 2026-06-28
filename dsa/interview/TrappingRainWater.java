package interview;

public class TrappingRainWater {
    /*
    [0, 1, 0, 2, 1,0, 1, 3, 2, 1, 2, 1]

    amount of water trapped on a building depends on
        -- max height on the left
        -- max height on the right

    amount of water stored =  Math.min( maxLeftHeight, maxRightHeight ) - currentHeight ) * 1

    formula will remain same, how can we efficiently calculate left and right height is something
    we need to look at

    1) take two arrays and store there - works but adds additional space complexity
    2) always process the shorter side, the taller side is never the problem

     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0, rMax = 0, waterTrapped = 0;

        while (left < right){
            if (height[left] <= height[right]){
                if (lMax >= height[left]) {
                    waterTrapped +=  lMax - height[left];
                } else{
                    lMax = height[left];
                }
                left++;
            } else{
                if (rMax >= height[right]){
                    waterTrapped += rMax - height[right];
                } else
                    rMax = height[right];
                right--;
            }
        }
        return waterTrapped;
    }
}

package arrays.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static int[][] mergeIntervals(int[][] intervals){
        // We don’t know the final output size in advance, so List gives dynamic growth,
        // and we convert it to a 2D array at the end.
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals){
            // adding
            if( ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]){
                ans.add(interval);
            }
            // merging
            ans.getLast()[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1] );
        }

        return ans.toArray(int[][] :: new);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = mergeIntervals(intervals);
        System.out.println(Arrays.toString(ans));
    }
}

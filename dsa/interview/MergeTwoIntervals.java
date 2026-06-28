package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoIntervals {
    /*
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]


        Sort them by starting time
        A and B are two intervals
        endA >= startB, they can be merged
        Merged sequence = [startA, Math.max( endA, endB ) ]

     */
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b ) -> a[0] - b[0]);

        for (int[] interval : intervals){
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]){
                ans.add(interval);
            }
            else{
                // merging logic here
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],
                        interval[1]);
            }
        }
        return ans.toArray(int[][] :: new);
    }
}

package dynamicprogramming;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    private int [][] jobs;
    private int[] memo;
    private int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        /*
            startTime = [1,2,3,3],
            endTime =   [3,4,5,6],
            profit =    [50,10,40,70]

            Sort the jobs by starting time, will be useful when finding the next valid
            job

            At any step there are two valid choices
            Take the job = profit[i] + f(next valid job)
            next valid
            Skip the job = f(i + 1 )
         */
        n = profit.length;
        jobs = new int[n][3];

        for (int i = 0; i < n; i++){
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        memo = new int[n];

        return dfs(0);
    }
    public int dfs(int index){
        if (index >= n)
            return 0;
        if (memo[index] != 0)
            return memo[index];
        int currentEndTime = jobs[index][1];
        int currentProfit = jobs[index][2];

        // find the next valid job
        int nextValidIndex = search(jobs, currentEndTime, index + 1);

        // Take
        int takeProfit = currentProfit + dfs(nextValidIndex);
        int notTakeProfit = dfs(index + 1);
        int maxProfit = Math.max(takeProfit, notTakeProfit);
        memo[index] = maxProfit;
        return maxProfit;
    }

    // Either works, but left is the convention for "first position satisfying the condition" in lower-bound binary search
    public int search(int[][] jobs, int targetTime, int startIndex){
        int left = startIndex;
        int right = n;

        while (left < right){
            int mid = ( left + right)/2;
            if (jobs[mid][0] >= targetTime)
                right = mid;
            else
                left = mid + 1;
        }
        // why return left?
        /*
        Mental model:

        1) [ startIndex.....left - 1] --> definitely invalid ( startTime < targetTime )
        2) [ right......n - 1] ---> definitely valid( startTime >= targetTime )
        3) [left .... right - 1] --> Unknown territory

        when left == right, the unknown territory disappears, and left is pointing
        exactly at the first valid index
         */

        return left;
    }
}

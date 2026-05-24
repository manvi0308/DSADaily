package dynamicprogramming;

public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // only down or right
        // from top-left to bottom-right
        // obstacle -> 1, space --> 0

        // if there is obstacle at the very first step, we can't move ahead
        if (obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[n][m];

        // first row
        for (int i = 0; i < m; i++){
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else break;
        }

        // first col
        for (int i = 0; i < n; i++){
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else break;
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}

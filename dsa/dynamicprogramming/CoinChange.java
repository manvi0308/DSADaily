package dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public int numberOfWays(int index, int amount, int[][] dp, int[] coins){
        if (amount == 0)
            return 1;
        if (index == coins.length)
            return 0;
        if (dp[index][amount] != -1)
            return dp[index][amount];
        if (coins[index] > amount)
            return dp[index][amount] = numberOfWays(index + 1, amount, dp, coins);
        return dp[index][amount] = numberOfWays(index + 1, amount, dp, coins )
                + numberOfWays(index, amount - coins[index], dp, coins);
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return numberOfWays(0, amount, dp, coins);
    }
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        /*
        1, 1, 1, 1, 1
        1, 1, 1, 2
        1, 2, 2
        5
         */
        CoinChange cc = new CoinChange();
        System.out.println(cc.change(amount, coins));
    }
}

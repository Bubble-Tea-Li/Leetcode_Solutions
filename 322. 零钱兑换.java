class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        Time: O(n*amount) Space: O(amount)
        对于最后一个状态dp[amount] = dp[amount - {coin} in coins] + 1
        相似：279完全平方数
        */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

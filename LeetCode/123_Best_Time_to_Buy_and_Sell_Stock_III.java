// dp[i][j] -> 最多交易i次时在第j天能获得的最大利润
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int k = 2;
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }

        return dp[k][n - 1];
    }
}
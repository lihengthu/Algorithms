// 1. https://www.jiuzhang.com/solution/best-time-to-buy-and-sell-stock-iii/
// dp[i][j] -> 最多交易i次时在第j天能获得的最大利润
// maxDiff -> 最多交易i-1次，从0到j-1天（最大利润 - 当天价格）的最大值
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length, k = 2;
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }

        return dp[k][n - 1];
    }
}
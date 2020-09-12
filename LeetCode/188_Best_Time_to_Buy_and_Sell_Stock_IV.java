class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        int[][] dp = new int[2][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                maxDiff = Math.max(maxDiff, dp[(i - 1) % 2][j - 1] - prices[j]);
                dp[i % 2][j] = Math.max(dp[i % 2][j - 1], prices[j] + maxDiff);
            }
        }

        return dp[k % 2][n - 1];
    }
}

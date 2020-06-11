
2. 另一种写法，dp[i][j]表示i -> j这段气球的最大收益
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = i; k < j + 1; k++) {
                    int l = i > 0 ? nums[i - 1] : 1;
                    int r = j < n - 1 ? nums[j + 1] : 1;
                    dp[i][j] = Math.max(dp[i][j], (k - 1 >= 0 ? dp[i][k - 1] : 0) + (k + 1 <= n ? dp[k + 1][j] : 0) + l * nums[k] * r);
                }
            }
        }
        return dp[0][n - 1];
    }
}

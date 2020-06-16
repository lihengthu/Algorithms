// 区间dp

// 1. dp[i][j]表示burst掉[i+1,j-1]之间的所有气球，只保留i和j两个气球的最大收益。
// 在前后添加两个气球且均为1
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            A[i] = nums[i - 1];
        }

        n += 2;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

// 2. 另一种写法，dp[i][j]表示burst掉i->j这段气球的最大收益
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

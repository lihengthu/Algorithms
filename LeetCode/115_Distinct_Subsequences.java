// 1. 未优化空间
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        if (s.length() == 0 || t.length() == 0) {
            return 1;
        }

        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

// 2. 滚动数组, dp[j]依赖于dp[j - 1], 所以从后向前遍历
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int m = t.length(), n = s.length();
        if (m == 0 || n == 0) {
            return 1;
        }

        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m];
    }
}

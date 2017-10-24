Analysis: 
    1. 和《剑指Offer》上的稍微不同
Solutions:

1. By myself 
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        return dp[n][n];
    }
}

2. Discuss - https://discuss.leetcode.com/topic/78603/straight-forward-java-dp-solution
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
}
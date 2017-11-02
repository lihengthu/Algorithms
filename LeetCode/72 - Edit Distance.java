Analysis: 
    1. Fabinacci

Solutions:

1. 
class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int i, j;
        int m = s1.length;
        int n = s2.length;

        int[][] dp = new int[m + 1][n + 1];
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+ 1;
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }
}
Analysis: 
    1. 

Solutions:

1. 
public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        int n = A.length(), m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = 0;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
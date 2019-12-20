class Solution {
    public boolean isMatch(String s, String p) {
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        int m = schar.length;
        int n = pchar.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (pchar[j - 1] != '*') {
                    if (i > 0 && (pchar[j - 1] == '?' || pchar[j - 1] == schar[i - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1];
                    if (i > 0){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
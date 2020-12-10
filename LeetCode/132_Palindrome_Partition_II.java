class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 3 || dp[i + 1][j - 1]);
            }
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        // j扩了一个维度
        for (int j = 1; j <= n; j++) {
            f[j] = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (dp[i][j - 1]) {
                    f[j] = Math.min(f[j], f[i] + 1);
                }
            }
        }
        return f[n] - 1;
    }
}
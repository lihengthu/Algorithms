// dp[i] = min{dp[j] + 1} (j < i 并且 s[j + 1], s[j + 2], ... , s[i] 是回文串)
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalin[j + 1][i - 1])) {
                    isPalin[j][i] = true;
                }
            }
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[n] - 1;
    }
}
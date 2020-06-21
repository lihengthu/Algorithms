public class Solution {
    public int backPack(int m, int[] A) {
        if (m == 0 || A.length == 0) {
            return 0;
        }
        
        // dp[i] 表示背包容量为i的情况下，最大的装载量
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}
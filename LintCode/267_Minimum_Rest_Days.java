public class Solution {
    public int minimumRestDays(List<Integer> company, List<Integer> gym) {
        int n = company.size();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = dp[0][1] = 0;
        if (company.get(0) == 0) {
            dp[0][0] = 1;
        }
        if (gym.get(0) == 0) {
            dp[0][1] = 1;
        }
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            if (company.get(i) == 1) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]);
            }
            if (gym.get(i) == 1) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            }
            dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + 1;

        }
        return Math.min(dp[n - 1][2], Math.min(dp[n - 1][0], dp[n - 1][1]));
    }
}
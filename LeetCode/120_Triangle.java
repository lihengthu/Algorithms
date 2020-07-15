// 1. dp[i][j] -> 从(0,0) 到 (i,j)的最小值
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }

        int n = triangle.size();
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int result = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }
}

// 2. 滚动数组优化空间，空间复杂度O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }

        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle.get(i).get(0);
            dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle.get(i).get(j);
            }
        }

        int result = dp[(n - 1) % 2][0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[(n - 1) % 2][i]);
        }

        return result;
    }
}

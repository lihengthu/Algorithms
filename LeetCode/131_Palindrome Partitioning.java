class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 3 || dp[i + 1][j - 1]);
            }
        }

        helper(result, new ArrayList<>(), dp, s, 0);

        return result;
    }

    private void helper(List<List<String>> result, List<String> list, boolean[][] dp, String s, int start) {
        if (start == dp.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 之所以用j，是因为习惯用[i, j]表示范围，有利于理解和记忆算法
        for (int j = start; j < dp.length; j++) {
            if (dp[start][j]) {
                list.add(s.substring(start, j + 1));
                helper(result, list, dp, s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
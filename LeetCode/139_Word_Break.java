class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }

        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int l = 1; l <= maxLength; l++) {
                if (i < l) {
                    break;
                }
                if (!dp[i - l]) {
                    continue;
                }
                String word = s.substring(i - l, i);
                if (dict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
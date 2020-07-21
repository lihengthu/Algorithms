
// 1. Backtracking
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }

    private void backtrack(List<List<String>> result, List<String> list, String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String substr = s.substring(start, i);
            if (isPalindrome(substr)) {
                list.add(substr);
                backtrack(result, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}

// 2. DF + Backtracking
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    // 取dp[j][i]而不是dp[i][j]
                    dp[j][i] = true;
                }
            }
        }

        backtrack(result, new ArrayList<>(), s, dp, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> list, String s, boolean[][] dp, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                backtrack(result, list, s, dp, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
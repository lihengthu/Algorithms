// 1. DP - O(n^2) - O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }
}

// 2. 
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxlen) {
                start = i - (len - 1) / 2;
                maxlen = len;
            }
        }

        return s.substring(start, start + maxlen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}

// 3. O(n) - 马拉车算法 - 最优
http://jucongyuan.github.io/2017/04/21/%E9%A9%AC%E6%8B%89%E8%BD%A6(Manacher)%E7%AE%97%E6%B3%95/
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder("$");
        for (char c : s.toCharArray()) {
            stringBuilder.append("#");
            stringBuilder.append(c);
        }
        stringBuilder.append("#");
        String str = stringBuilder.toString();

        int id = 0;
        int idMax = 0;
        int index = 0;
        int maxLength = 0;
        int p[] = new int[str.length()];
        for (int curr = 1; curr < str.length(); curr++) {
            int j = 2 * id - curr;
            // p[curr] = idMax > curr ? Math.min(p[symmetryId], idMax - curr) : 1;
            // 更容易理解的写法
            if (idMax > curr) {
                if (p[j] < idMax - curr)
                    p[curr] = p[j];
                else
                    p[curr] = idMax - curr;
            } else {
                p[curr] = 1;
            }
            while (curr + p[curr] < str.length() && str.charAt(curr + p[curr]) == str.charAt(curr - p[curr])) {
                p[curr]++;
            }
            if (curr + p[curr] > idMax) {
                id = curr;
                idMax = curr + p[curr];
            }
            if (p[curr] > maxLength) {
                maxLength = p[curr];
                index = curr;
            }
        }
        return s.substring((index - maxLength) / 2, (index + maxLength) / 2 - 1);
    }
}

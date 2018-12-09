Solutions:

1. DP - O(n^2) - O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && res.length() < i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}

2. 基于中心点枚举
(1) Self
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = "";
        int n = s.length();
        for (int i = 1; i <= 2 * n + 1; ++i) {
            String res = expandFromCenter(s, i);
            if (res.length() > result.length()) {
                result = res;
            }
        }
        return result;
    }

    private String expandFromCenter(String s, int index) {
        String res = "";
        int n = s.length();
        int l = ((index - 1) >> 1) - 1, r = index >> 1;
        while (l >= 0 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                res = s.substring(l, r + 1);
                --l;
                ++r;
            } else {
                break;
            }
        }
        if (index == 1) {
            res = s.substring(0,1);
        }
        return res;
    }
}

(2) JiuZhang - 个人感觉九章逻辑更清晰
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findLongestPalindromeFrom(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
            
            len = findLongestPalindromeFrom(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        
        return s.substring(start, start + longest);
    }
    
    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }
        
        return len;
    }
}
(3) Solution - 重点理解start的计算在奇偶都适用
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

3. O(n) - 马拉车算法 - 最优
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

Analysis:
    1. 分为两种情况，第二个字符是"*"，和第二个字符不是"*", 难点在第二个是"*"的处理，可以借助非确定有限状态机来理解，分别是匹配0个、1个、多个的情况；
    2. Java 里，时刻检验数组是否越界。
    3. LeetCode 10，但是函数的参数不一样。

Solutions:

1. 递归解法 - 22 lines - Round 2: 艰难AC;
public class Solution {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int sIndex, int pIndex) {
        if (sIndex == str.length && pIndex == pattern.length)
            return true;
        if (sIndex < str.length && pIndex == pattern.length)
            return false;
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.'))
                return matchCore(str, pattern, sIndex, pIndex + 2)
                        || matchCore(str, pattern, sIndex + 1, pIndex)
                        || matchCore(str, pattern, sIndex + 1, pIndex + 2);
            else
                return matchCore(str, pattern, sIndex, pIndex + 2);
        }
        if ((sIndex < str.length) && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.'))
            return matchCore(str, pattern, sIndex + 1, pIndex + 1);
        return false;
    }
}

2. 动态规划 - 2D_DP - 思路分析见LeetCode 10 Discuss
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if(pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) 
                    dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.') 
                        dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}
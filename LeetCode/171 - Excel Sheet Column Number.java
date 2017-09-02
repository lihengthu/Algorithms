Analysis: 
    1. 理解进制，26进制
Solutions:

1. 自己写的，不够简洁
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] str = s.toCharArray();
        int res = 0;
        for (int i = 0; i < str.length; ++i) {
            res += (str[i] - 'A' + 1) * Math.pow(26, str.length - i - 1);
        }
        return res;
    }
}

2. Discuss -- 8 lines
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
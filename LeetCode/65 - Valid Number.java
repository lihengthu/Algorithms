Analysis: 
    1. 无聊的题目

Solutions:

1. Discuss
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}

2. JiuZhang
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        int i = 0, e = len - 1;
        if (i > len - 1) return false;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') ++i;
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || num == false) return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e')
                    return false;
            } else {
                return false;
            }
            ++i;
        }
        return num;
    }
}
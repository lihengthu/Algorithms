首先应该明确合法的数字有哪些:

整数, 例如 "122", "114"
浮点数, 例如 "1.2", "2.", ".5", "1e10", "1E10"
上面两种数加上符号, 即 "+" 或 "-"
"2.", ".5" 这两种形式可能让你有点迷惑, 你可以试一试, 在大多数编程语言中它们都是合法的字面量.

为了方便, 我们可以先处理掉首尾的空白字符. 然后再判断第一个是否符号, 如果是也过滤掉.

然后, 剩下的字符串就只能包含 0-9, ., e/E 这三类字符了, 如果含有这三类之外的, 直接返回 false 即可. 然后根据以下原则判断即可:

1. 小数点和 e/E 都至多只能出现 1 次
2. 如果含有小数点, 则小数点前后至少有一个数字, 一个孤立的小数点是非法的.
3. 如果含有 e/E, 则它的前后必须有数字.

class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        int i = 0, e = len - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i > len - 1) {
            return false;
        }
        while (e >= i && Character.isWhitespace(s.charAt(e))) {
            e--;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (i <= e) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = true;
            } else if (ch == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (ch == 'e') {
                if (exp || num == false) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (ch == '+' || ch == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return num;
    }
}
Analysis:
    1. 注意考虑全各种情况，可以先分类把所有 Test Cases 都写出来，正负、科学计数法等;
    2. LeetCode 未找到;

Solutions:

1. 第一遍AC - 31 lines
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null) return false;
        int index = 0;
        if (str[index] == '+' || str[index] == '-')
            ++index;
        while (str[index] >= '0' && str[index] <= '9'){
            ++index;
            if (index == str.length) return true;
        }
        if (str[index] == '.') {
            ++index;
            if (index == str.length) return false;
            while (str[index] >= '0' && str[index] <= '9'){
                ++index;
                if (index == str.length) return true;
            }
        }
        if (str[index] == 'e' || str[index] == 'E') {
            ++index;
            if (index == str.length) return false;
            if (str[index] == '+' || str[index] == '-')
                ++index;
            if (str[index] == '0') return false;
            while (str[index] >= '0' && str[index] <= '9'){
                ++index;
                if (index == str.length) return true;
            }
        }
        if (index == str.length) return true;
        return false;
    }
}

2. 正则表达式
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
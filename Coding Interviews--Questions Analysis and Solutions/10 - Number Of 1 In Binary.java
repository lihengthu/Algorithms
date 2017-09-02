Analysis:
    1. 

Solutions:
1. 常规解法 循环次数等于整数二进制的位数，32位即为32次
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                ++cnt;
            flag <<= 1;
        }
        return cnt;
    }
}
2. 惊喜解法
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;
            n &= (n - 1);
        }
        return cnt;
    }
}
3. API
public class Solution {
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0","").length();
    }
}
4. 可能引起死循环的解法，不推荐
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n & 1 != 0)
                ++cnt;
            n >>= 1;
        }
        return cnt;
    }
}
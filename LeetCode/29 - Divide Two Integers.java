Analysis: 
    1. 位运算 Bit Manipulation
    2. 分析出 溢出的两种情况：(1) divisor == 0; (2) dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
    3. 把dividend和divisor 转成long, 再取求abs; 因为 Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE;
    参考：https://stackoverflow.com/questions/5444611/math-abs-returns-wrong-value-for-integer-min-value
Solutions:

1. 位运算
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }
}

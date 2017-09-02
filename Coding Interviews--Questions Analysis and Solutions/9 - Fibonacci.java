Analysis:
    1. 有O(logn)的解法，隐含时间常数较大，不是实用的解法;

Solutions:
1. 比自己的简洁
public class Solution {
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int i = 0, j = 1;
        while (n-- > 0) {
            j += i;
            i = j - i;
        }
        return i;
    }
}
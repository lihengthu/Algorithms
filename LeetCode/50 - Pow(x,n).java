Analysis: 
    1. corner cases ： Integer.MIN_VALUE, n 的正负

Solutions:

1. 递归
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            else return 1.0 / myPow(x, -n);
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

2. 迭代 Iterative
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long absN = Math.abs((long) n); // deal with Integer.MIN_VALUE;
        while (absN > 0) {
            if ((absN & 1) == 1) res *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}

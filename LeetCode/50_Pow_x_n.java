class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if (n < 0) {
            x = 1 / x;
            isNeg = true;
            n = -(n + 1);
        }
        double res = 1, tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        if (isNeg) {
            res *= x;
        }
        return res;
    }
}
Analysis:
    1. 牛客的测试用例不全

Solutions:
1. 应该先把exponent 强制转换为long，再取反，以覆盖Integer.MIN_VALUE
public class Solution {
    public double Power(double base, int exponent) {
        double res = 1, curr = base;
        int absExponent = exponent;
        if (exponent < 0) {
            if (Double.compare(base, 0) == 0)
                return 0;
            absExponent = -exponent;
        }
        while (absExponent != 0) {
            if ((absExponent & 1) == 1)
                res *= curr;
            curr *= curr;
            absExponent >>= 1;
        }
        return exponent < 0 ? 1 / res : res;
    }
}
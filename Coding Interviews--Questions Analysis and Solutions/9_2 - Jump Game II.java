Analysis:
    1. 关键是递推公式写对，尤其是最后的1，表示一次跳上n阶台阶；
    f(n) = f(n-1) + f(n-2) + ... + f(1) + 1;
    f(n-1) = f(n-2) + f(n-3) + ... + f(1) + 1;
    作差得，f(n) = 2 * f(n-1);
Solutions:
1. 如果能整理出公式 f(n) = pow(2,n - 1) + 位运算
public class Solution {
    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}
2. --i 的应用
public class Solution {
    public int JumpFloorII(int target) {
        int res = 1;
        while (--target > 0) {
            res *= 2;
        }
        return res;
    }
}
Analysis:
    1. 将B[i] 分成前后两部分的乘积;
    2. LeetCode 238, LeetCode Follow-Up 要求更高，不能使用额外的空间。

Solutions:

1. 朴素解法 - 时间复杂度 O(n), 空间复杂度 O(n) - Round 2 只使用朴素解法AC;
public class Solution {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) return false;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return false;
        }
        for (int i = 0; i < length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}

2. 时间复杂度 O(n), 空间复杂度 O(1) - 结合《剑指Offer》中的图更容易理解，分别计算下三角和上三角的乘积;
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return null;
        int[] mul = new int[A.length];
        mul[0] = 1;
        //计算下三角连乘
        for (int i = 1; i < A.length; ++i)
            mul[i] = mul[i - 1] * A[i - 1];
        int tmp = 1;
        //计算上三角连乘
        for (int j = A.length - 2; j >= 0; --j){
            tmp *= A[j + 1];
            mul[j] *= tmp;
        }
        return mul;
    }
}
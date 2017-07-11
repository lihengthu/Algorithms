Analysis:
    1. 使用HashSet会占用 O(n) 的额外空间，
    2. LeetCode 287, 但题目和要求都略有不同。LeetCode 不允许修改原数组;

Solutions:

1. 时间复杂度 O(n)，空间复杂度 O(1) -- 改变原数组 -- 《剑指Offer》答案 -- Round 2 记得思路，未能15 minutes AC;
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
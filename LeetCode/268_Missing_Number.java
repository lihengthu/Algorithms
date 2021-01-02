// 异或位运算的性质：
// n ^ n =0, n ^ 0 = n, 且异或满足交换律和结合律
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result ^= i ^ nums[i];
        }

        return result;
    }
}
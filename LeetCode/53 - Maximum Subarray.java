Analysis: 
    1. 1-D DP；

Solutions:

1. // 常规思路
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

2. // Discuss 效率和上面差不多
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxSoFar = nums[0], maxEndHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
}
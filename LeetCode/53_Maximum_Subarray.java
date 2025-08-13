// 1) 滑动窗口
class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;

            // 更新答案
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 判断窗口是否要收缩
            while(windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -=  nums[left];
                left++;
            }
        }
        return maxSum;
    }
}

// 2) 动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
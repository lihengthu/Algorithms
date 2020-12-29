// 1. Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean result = false;
        int reach = nums[0];
        for (int i = 0; i <= reach; i++) {
            if (i + nums[i] >= n - 1) {
                return true;
            }
            reach = Math.max(reach, i + nums[i]);
        }

        return result;
    }
}

// 2. DP
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
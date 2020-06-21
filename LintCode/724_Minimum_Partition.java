public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int sum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                result = Math.abs(sum - 2 * i);
                break;
            }
        }
        return result;
    }
}
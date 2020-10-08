class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int i = 0, j = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (j < n) {
            sum += nums[j++];
            while (sum >= s) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, minLen = nums.length + 1, sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                }
                sum -= nums[l];
                l++;
            }
        }

        return minLen > nums.length ? 0 : minLen;
    }
}
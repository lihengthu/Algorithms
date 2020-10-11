class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        left[1] = nums[0];
        right[1] = nums[1];
        for (int i = 2; i < n; i++) {
            left[i] = Math.max(left[i - 2] + nums[i - 1], left[i - 1]);
            right[i] = Math.max(right[i - 2] + nums[i], right[i - 1]);
        }

        return Math.max(left[n - 1], right[n - 1]);
    }
}

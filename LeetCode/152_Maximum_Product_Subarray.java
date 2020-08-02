// 1.
class Solution {
    public int maxProduct(int[] nums) {
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];

        f[0] = nums[0];
        g[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]));
            g[i] = Math.min(nums[i], Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]));
            max = Math.max(max, f[i]);
        }

        return max;
    }
}

// 2.
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minPre = nums[0], maxPre = nums[0];
        int min = nums[0], max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
            result = Math.max(result, max);
            maxPre = max;
            minPre = min;
        }

        return result;
    }
}
Analysis: 

Solutions:

1. JiuZhang
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int res = nums[0];
        min[0] = max[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
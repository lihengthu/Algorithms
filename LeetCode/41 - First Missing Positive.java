Analysis: 
    1. ^操作实现swap函数
    2. swap思路想到，但没能坚持实现出来
Solutions:

1. swap -- 19 lines
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) return 0;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
Analysis: 
    1. 关键是想通交换哪两个元素，可借助于实例;

Solutions:

1. // 自己写的 -- 29 lines
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int maxLeft = -1, maxRight = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i] && j > maxLeft) {
                    maxLeft = j;
                    maxRight = i;
                    break;
                }
            }
        }
        if (maxLeft != -1) {
            int tmp = nums[maxLeft];
            nums[maxLeft] = nums[maxRight];
            nums[maxRight] = tmp;
            reverse(nums, maxLeft + 1, nums.length - 1);
            return;
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start; i < ((start + end + 1) >> 1); ++i) {
            int tmp = nums[i];
            nums[i] = nums[end - i + start];
            nums[end - i + start] = tmp;
        }
    }
}
2. // Discuss
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) --j;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }
}
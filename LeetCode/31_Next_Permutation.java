class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        reverse(nums, i, nums.length - 1);
        if (i != 0) {
            int j = i;
            while (nums[j] <= nums[i - 1]) {
                ++j;
            }
            swap(nums, i - 1, j);
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            ++start;
            --end;
        }
    }
}
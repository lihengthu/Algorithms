1.
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) return 0;
        for (int i = 0; i < nums.length; ++i) {
            // 数组中可能有重复数字，比如 [1, 1]，因此只用 nums[i] != (i + 1) 会进入死循环导致TLE.
            // 使用^实现swap的前提是数组中的i，j不能相等。记于印象笔记
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

2. 参考，九章
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
                int tmp = nums[nums[i] - 1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }

        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
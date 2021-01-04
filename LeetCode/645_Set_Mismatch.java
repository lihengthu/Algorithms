// 1. 第二种略长，记第一种
class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{dup, missing};
    }
}

// 2.
class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= (i + 1) ^ nums[i];
        }

        int rightmost = xor & ~(xor - 1);
        for (int num : nums) {
            if ((num & rightmost) != 0) {
                xor1 ^= num;
            } else {
                xor0 ^= num;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmost) != 0) {
                xor1 ^= i;
            } else {
                xor0 ^= i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0) {
                return new int[]{xor0, xor1};
            }
        }

        return new int[]{xor1, xor0};
    }
}
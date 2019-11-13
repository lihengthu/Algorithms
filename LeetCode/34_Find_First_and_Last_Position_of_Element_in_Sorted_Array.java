class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int res = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target <= nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            if (nums[m] == target) {
                res = m;
            }
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int res = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            if (nums[m] == target) {
                res = m;
            }
        }
        return res;
    }
}
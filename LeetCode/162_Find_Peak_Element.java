class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[l] > nums[r] ? l : r;
    }
}

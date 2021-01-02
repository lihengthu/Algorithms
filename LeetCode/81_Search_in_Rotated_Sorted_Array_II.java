class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r--;
            }
        }
        
        return false;
    }
}
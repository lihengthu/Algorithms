class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
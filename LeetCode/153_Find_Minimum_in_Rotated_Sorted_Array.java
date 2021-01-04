// LeetCode Solution 不够简洁, 原因是基于标准二分，必须判断inflection point
// https://www.jiuzhang.com/solution/find-minimum-in-rotated-sorted-array/
// 基于lower_bound()版本, 退出循环时: l == r
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = (l + r) >>> 1;
            if (nums[mid] < nums[l]) {
                // 最小值在 [l, mid]
                r = mid;
            } else {
                // 最小值在 (mid, r]
                l = mid + 1;
            }
        }
        
        return nums[l];
    }
}
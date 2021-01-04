// https://www.jiuzhang.com/solution/find-minimum-in-rotated-sorted-array-ii/
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
                r = mid;
            } else if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                l++;
            }
        }

        return nums[l];
    }
}
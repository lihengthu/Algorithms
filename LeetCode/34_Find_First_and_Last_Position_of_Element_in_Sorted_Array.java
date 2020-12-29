// https://blog.csdn.net/liheng301/article/details/106008882
// 记忆/理解三种二分即可：
// 1）标准JDK版本二分；
// 2）lower_bound() 版本，求nums[i] >= target的下界；
// 3）upper_bound()版本，求nums[i] > target的下界；
// 重点理解最终l和r的搜索区间和最终位置，其他的上下界由上述三种三种转换即可；
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        result[0] = l < n && nums[l] == target ? l : -1;

        l = 0;
        r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        result[1] = l - 1 >= 0 && nums[l - 1] == target ? l - 1 : -1;

        return result;
    }
}
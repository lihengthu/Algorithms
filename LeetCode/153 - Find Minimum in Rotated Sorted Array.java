Analysis: 
	1. 简单版本，数组中无重复数字;
Solutions:

1. 自己，思路借鉴是《剑指Offer》上面，令 l 指针指向左边矩阵的最右元素， r 指针指向右半矩阵的最左元素；
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];
        while (r - l > 1) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[l])
                l = mid;
            else
                r = mid;
        }
        return nums[r];
    }
}

2. // Discuss 
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r])
                return nums[l];
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= nums[l])
                l = mid + 1;
            else
                r = mid;
        }
        return nums[l];
    }
}
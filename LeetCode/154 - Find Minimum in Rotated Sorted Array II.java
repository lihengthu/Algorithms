Analysis: 
	1. 升级版本，数组中可能有重复数字;
Solutions:

1. 自己，借鉴《剑指Offer》上面，令 l 指针指向左边矩阵的最右元素， r 指针指向右半矩阵的最左元素；
    如果发现 nums[l] == nums[r] && nums[l] == nums[r] 则改为顺序查找
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];
        while (r - l > 1) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == nums[l] && nums[l] == nums[r])
                return seqSearch(nums, l, r);
            if (nums[mid] >= nums[l])
                l = mid;
            else r = mid;
        }
        return nums[r];
    }

    private int seqSearch(int[] nums, int l, int r) {
        int min = nums[l];
        for (int i = l + 1; i <= r; ++i) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}

2. // Discuss 相当巧妙的解法
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[r])
                r = mid;
            else if (nums[mid] > nums[r])
                l = mid + 1;
            else r--;
        }
        return nums[l];
    }
}
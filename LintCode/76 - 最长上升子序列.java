Analysis: 
    1. 

Solutions:

1. O(n^2)
public class Solution {
    /*
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i])
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
            }
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }
}

2. O(nlgn)
public class Solution {
    
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; ++i)
            minLast[i] = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }
        for (int i = nums.length; i >= 1; --i) {
            if (minLast[i] != Integer.MAX_VALUE)
                return i;
        }
        return 0;
    }
    // 找第一个大于等于key的index
    private int binarySearch(int[] minLast, int key) {
        int mid, l = 0, r = minLast.length - 1;
        while (l < r) {
            mid = ((r - l) >> 1) + l;
            if (minLast[mid] == key)
                return mid;
            else if (minLast[mid] < key)
                l = mid + 1;
            else r = mid;
        }
        if (minLast[r] > key) return r;
        return -1;
    }
}
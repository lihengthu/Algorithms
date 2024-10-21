// 1. O(N^2)
// dp[i] 表示以第i个数字为结尾的最长上升子序列的长度。
// 对于每个数字，枚举前面所有小于自己的数字j，dp[i] = max{dp[j]} + 1. 如果没有比自己小的，dp[i] = 1;
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i]表示以第i个位置结尾的最长上升子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] = nums[j] < nums[i] ? Math.max(dp[j] + 1, dp[i]) : dp[i];
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}

// 2. 贪心 + Binary Search
// 注意二分查找的写法
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // 辅助数组dp[i]表示长度为i的最长上升子序列的末尾元素的最小值
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        int len = 1;

        for (int i = 1; i < n; ++i) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                bs(dp, len, nums[i]);
            }
        }

        return len;
    }

    public void bs(int[] nums, int len, int target) {
        int l = 1, r = len;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                return;
            }
        }

        nums[r + 1] = target;
    }
}
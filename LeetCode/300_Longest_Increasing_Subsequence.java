// 1. O(N^2)
// dp[i] 表示以第i个数字为结尾的最长上升子序列的长度。
// 对于每个数字，枚举前面所有小于自己的数字j，dp[i] = max{dp[j]} + 1. 如果没有比自己小的，dp[i] = 1;
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length, result = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}

// 2. DP + Binary Search
// 开一个辅助数组b, b[i]存储dp值为i的最小的数字。有多个位置，以这些位置为结尾的LIS长度都为i， 则这些数字中最小的一个存在b[i]中,则b数组严格递增。
// 且下标表示LIS长度，也是严格递增，可以在B数组中进行二分查找。
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length, len = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int index = bs(dp, 0, len - 1, nums[i]);
            if (index == -1) {
                dp[len++] = nums[i];
            } else {
                dp[index] = nums[i];
            }
        }

        return len;
    }

    public int bs(int[] nums, int left, int right, int target) {
        int l = left, r = right + 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (l < right + 1) {
            return l;
        }
        return -1;
    }
}
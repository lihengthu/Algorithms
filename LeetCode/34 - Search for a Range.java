Analysis: 
    1. 二分搜索的多种写法，必须熟练掌握；

Solutions:

1. 二分搜索 -- 经典的两种情况
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l =0, r = nums.length - 1;
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return res;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) return res;
        res[0] = l;
        // don't have to set i to 0 the second time
        r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] > target)
                r = mid - 1;
            else l = mid;
        }
        if (nums[r] != target) return res;
        res[1] = r;
        return res;
    }
}

2. LeetCode Discuss -- 巧妙的思路
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
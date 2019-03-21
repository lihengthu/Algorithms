
Solutions: 
1.
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int closestSum = nums[i] + nums[lo] + nums[hi];
                    if (closestSum == target) {
                        return target;
                    } else if (closestSum < target ) {
                        while (lo < hi && nums[lo + 1] == nums[lo]) {
                            ++lo;
                        }
                        ++lo;
                    } else {
                        while (hi > lo && nums[hi - 1] == nums[hi]) {
                            --hi;
                        }
                        --hi;
                    }
                    if (Math.abs(closestSum - target) < Math.abs(result - target)) {
                        result = closestSum;
                    }
                }
            }
        }
        return result;
    }
}
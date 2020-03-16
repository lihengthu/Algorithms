1. DP, O(n^2)
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;
        for (int i = 1; i < nums.length; ++i){
            for (int j = 0; j < i; ++j){
                if (jump[j] && j + nums[j] >= i){
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[nums.length - 1];
    }
}

2. Greedy
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int farthest = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (i <= farthest && nums[i] + i >= farthest) {
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length - 1;
    }
}
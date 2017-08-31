Analysis: 
    1. 自己写的代码还是太臃肿，不忍直视！

Solutions:

1. // 常规思路
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int reach = 0;
        for (int i = 0; i <= reach; ++i) {
            reach = Math.max(reach, nums[i] + i);
            if (reach >= nums.length - 1)
                return true;
        }
        return false;
    }
}
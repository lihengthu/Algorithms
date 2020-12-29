// 1. Discuss, BFS
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, jumps = 0, reach = 0;
        for (int i = 0; i < n - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == end) {
                jumps++;
                end = reach;
            }
        }

        return jumps;
    }
}
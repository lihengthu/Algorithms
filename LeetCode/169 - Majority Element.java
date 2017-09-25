Analysis: 

Solutions:

1.
class Solution {
    public int majorityElement(int[] nums) {
        int target = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == target)
                ++cnt;
            else --cnt;
            if (cnt == 0) {
                target = nums[i];
                cnt = 1;
            }
        }
        return target;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                majority = num;
            }
            cnt += num == majority ? 1 : -1;
        }

        return majority;
    }
}

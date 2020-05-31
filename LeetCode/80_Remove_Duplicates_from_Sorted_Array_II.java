class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if (cnt < 2) {
                    nums[++index] = nums[i];
                    cnt++;
                }
            } else {
                nums[++index] = nums[i];
                cnt = 1;
            }
        }
        return index + 1;
    }
}
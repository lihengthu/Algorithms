class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, cnt = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[l]) {
                if (cnt < 2) {
                    nums[++l] = nums[r];
                    cnt++;
                }
            } else {
                nums[++l] = nums[r];
                cnt = 1;
            }
        }

        return l + 1;
    }
}
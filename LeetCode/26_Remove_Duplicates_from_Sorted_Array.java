class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
        }

        return l + 1;
    }
}
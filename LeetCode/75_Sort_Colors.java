class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0, pl = 0, pr = nums.length - 1;
        while (i <= pr) {
            if (nums[i] == 0) {
                nums[i++] = nums[pl];
                nums[pl++] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[pr];
                nums[pr--] = 2;
            } else {
                i++;
            }
        }
    }
}
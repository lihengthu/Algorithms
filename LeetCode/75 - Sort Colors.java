Analysis: 
    1. Fabinacci

Solutions:

1. 2-pass
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0)
                ++red;
            else if (nums[i] == 1)
                ++white;
            else ++blue;
        }
        Arrays.fill(nums, 0, red, 0);
        Arrays.fill(nums, red, red + white, 1);
        Arrays.fill(nums, red + white, nums.length, 2);
    }
}

2. 1-pass
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0, r = nums.length - 1, index = 0;
        while (index <= r){
            if (nums[index] == 0){
                nums[index++] = nums[l];
                nums[l++] = 0;
            }
            else if (nums[index] == 2){
                nums[index] = nums[r];
                nums[r--] = 2;
            }
            else ++index;
        }
    }
}
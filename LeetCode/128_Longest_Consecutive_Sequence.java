// 1. Set
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
            
            int low = nums[i] - 1;
            while (set.contains(low)) {
                set.remove(low);
                low--;
            }
            int high = nums[i] + 1;
            while (set.contains(high)) {
                set.remove(high);
                high++;
            }

            longest = Math.max(longest, high - low - 1);
        }

        return longest;
    }
}

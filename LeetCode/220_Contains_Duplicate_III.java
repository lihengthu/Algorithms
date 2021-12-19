class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }

        int minest = Integer.MAX_VALUE;
        for (int num : nums) {
            minest = Math.min(minest, num);
        }

        Map<Long, Integer> bucket = new HashMap<>();
        int range = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long index = ((long) nums[i] - (long) minest) / range;
            Integer curr = bucket.get(index);
            if (curr != null && findAns(nums, curr, i, t)) {
                return true;
            }
            Integer left = bucket.get(index - 1);
            if (left != null && findAns(nums, left, i, t)) {
                return true;
            }
            Integer right = bucket.get(index + 1);
            if (right != null && findAns(nums, right, i, t)) {
                return true;
            }
            bucket.put(index, nums[i]);
            if (i >= k) {
                Long indexToRemove = ((long) nums[i - k] - (long) minest) / range;
                bucket.remove(indexToRemove);
            }
        }

        return false;
    }

    private boolean findAns(int[] arr, int i, int j, int t) {
        return Math.abs((long) i - (long) arr[j]) <= t;
    }
}
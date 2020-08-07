// 1. Bucket Sort
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int minV = nums[0], maxV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minV = Math.min(minV, nums[i]);
            maxV = Math.max(maxV, nums[i]);
        }

        int bucketLength = (int)Math.ceil((double)(maxV - minV) / (nums.length - 1));
        if (bucketLength == 0) {
            return 0;
        }
        int[] bucketsMin = new int[nums.length - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        int[] bucketsMax = new int[nums.length - 1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == minV || num == maxV) {
                continue;
            }
            int idx = (num - minV) / bucketLength;
            bucketsMin[idx] = Math.min(num, bucketsMin[idx]);
            bucketsMax[idx] = Math.max(num, bucketsMax[idx]);
        }

        int maxGap = Integer.MIN_VALUE;
        int prev = minV;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i] - prev);
            prev = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, maxV - prev);

        return maxGap;
    }
}

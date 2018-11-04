1. Best Option
public int subarraySum(int[] nums, int k) {
        int result = 0, prevSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            prevSum += nums[i];
            result += map.getOrDefault(prevSum - k, 0);
            map.put(prevSum, map.getOrDefault(prevSum, 0) + 1);

        }
        return result;
    }
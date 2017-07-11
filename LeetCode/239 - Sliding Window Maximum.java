Analysis: 
    1. 把滑动窗口看成一个队列，但并不把窗口中的每个数值都存入队列中，而是只把可能成为滑动窗口最大值的数值存入双端队列;
    2. 双端队列中存入的是数字在数组中的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于等于滑动窗口的大小时，这个数字已经从窗口中滑出，即可以从队列中删除;

Solutions:

1. 双端队列 -- O(n) -- 15 lines
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k))
                deque.pollFirst();
            deque.offerLast(i);
            if (i >= k - 1)
                result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}

2. 待理解??? -- LeetCode Discuss
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] max_left = new int[nums.length];
        int[] max_right = new int[nums.length];
        max_left[0] = nums[0];
        max_right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);
            int j = nums.length - i - 1;
            max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
        }
        int[] sliding_max = new int[nums.length - k + 1];
        for (int i = 0, j = 0; i + k <= nums.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
        }
        return sliding_max;
    }
}
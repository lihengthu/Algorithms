// 1.
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

// 2.
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int cnt = 0;
        for (int start = 0; cnt < n; start++) {
            int curr = start;
            int prev = nums[start];
            do {
                int next = (curr + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                cnt++;
            } while (start != curr);
        }
    }
}

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int begin, int end, int k) {
        if (begin <= end) {
            int index = partition(nums, begin, end);
            if (index == nums.length - k) {
                return nums[index];
            } else if (index > nums.length - k) {
                return quickSort(nums, begin, index - 1, k);
            } else {
                return quickSort(nums, index + 1, end, k);
            }
        }

        return -1;
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}

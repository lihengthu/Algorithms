// 1. Merge Sort
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Top-down
    public void mergeSort(int[] nums, int l, int r) {
        int mid = l + ((r - l) >> 1);
        if (l < r) {
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

	// Bottom-up
	public void mergeSort(int[] nums) {
        int n = nums.length;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int l = 0; l < n - sz; l += 2 * sz) {
                merge(nums, l, l + sz - 1, Math.min(l + 2 * sz - 1, n - 1));
            }
        }
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (k = 0; k < temp.length; k++) {
            nums[k + l] = temp[k];
        }
    }
}

// 2. Quick Sort
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int p = partition(nums, lo, hi);
            quickSort(nums, lo, p - 1);
            quickSort(nums, p + 1, hi);
        }
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}


// 3. Heap Sort
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        heapSort(nums);

        return nums;
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
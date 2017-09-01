Analysis:
    1. 二分搜索变形

Solutions:
1. 
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (array[mid] > array[r])
                l = mid + 1;
            else if (array[mid] < array[r])
                r = mid;
            else r--;
        }
        return array[l];
    }
}
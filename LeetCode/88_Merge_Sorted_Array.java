class Solution {
    // 逆向双指针，避免开额外数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int idx = m + n - 1;
        
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[idx--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[idx--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[idx--] = nums2[p2--];
            } else {
                nums1[idx--] = nums1[p1--];
            }
        }
    }
}
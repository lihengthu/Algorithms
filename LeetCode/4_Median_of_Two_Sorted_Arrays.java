Solutions:

1. 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m;
        int halfLen = (m + n + 1) >> 1;
        double result = 0;
        while (imin <= imax) {
            int i = (imin + imax) >> 1;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                double leftMax = 0, rightMin = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                if (((m + n) & 1) == 1) {
                    result = leftMax;
                    break;
                }
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else rightMin = Math.min(nums1[i], nums2[j]);
                result = (leftMax + rightMin) / 2;
                break;
            }
        }
        return result;
    }
}
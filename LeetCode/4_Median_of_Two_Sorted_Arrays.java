class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = 0, k = 0;
        int left = -1, right = -1;

        while (k < (m + n) / 2 + 1) {
            left = right;

            if (j >= n || i < m && nums1[i] <= nums2[j]) {
                right = nums1[i++];
            } else {
                right = nums2[j++];
            }

            k++;
        }

        return (m + n) % 2 == 1 ? right : (left + right) / 2.0;
    }
}

// 详细解释：https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/258842/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;

        if (total % 2 == 1) {
            return getKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        }

        int firstValue = getKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2);
        int secondValue = getKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        return (firstValue + secondValue) / 2.0;
    }

    // 找第k小的元素
    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1 > end1) {
            return nums2[start2 + k - 1];
        } else if (start2 > end2) {
            return nums1[start1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        } else {
            int d = k / 2 - 1;
            int validLeft = Math.min(start1 + d, end1);
            int validRight = Math.min(start2 + d, end2);

            // 谁小谁排除
            if (nums1[validLeft] <= nums2[validRight]) {
                k -= (validLeft - start1 + 1);
                return getKth(nums1, validLeft + 1, end1, nums2, start2, end2, k);
            } else {
                k -= (validRight - start2 + 1);
                return getKth(nums1, start1, end1, nums2, validRight + 1, end2, k);
            }
        }
    }
}
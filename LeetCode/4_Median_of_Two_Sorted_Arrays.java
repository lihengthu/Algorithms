// 1. https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int half = (m + n + 1) >>> 1;
        int l = 0, r = m;
        while (l <= r) {
            int i = (l + r) >>> 1;
            int j = half - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                l = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else {
                double lmax = 0, rmin = 0;
                if (i == 0) {
                    lmax = nums2[j - 1];
                } else if (j == 0) {
                    lmax = nums1[i - 1];
                } else {
                    lmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // m + n 为奇数的情况
                if (((m + n) & 1) == 1) {
                    return lmax;
                }

                if (i == m) {
                    rmin = nums2[j];
                } else if (j == n) {
                    rmin = nums1[i];
                } else {
                    rmin = Math.min(nums1[i], nums2[j]);
                }
                result = (lmax + rmin) / 2;
                break;
            }
        }

        return result;
    }
}

// 2. https://www.jiuzhang.com/solution/median-of-two-sorted-arrays/#tag-lang-ALL
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if ((n & 1) == 0) {
            return (findKth(nums1, nums2, 0, 0, n / 2) +
                    findKth(nums1, nums2, 0, 0, n / 2 + 1)) / 2.0;
        }

        return findKth(nums1, nums2, 0, 0, n / 2 + 1);
    }

    // 找两个有序数组的第k大数
    // Divide and Conquer
    public int findKth(int[] A, int[] B, int startA, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int halfKthA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        // 注意k - k/2
        if (halfKthA < halfKthB) {
            return findKth(A, B, startA + k / 2, startB, k - k / 2);
        } else {
            return findKth(A, B, startA, startB + k / 2, k - k / 2);
        }
    }
}
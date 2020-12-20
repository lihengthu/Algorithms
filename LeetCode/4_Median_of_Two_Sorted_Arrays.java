// 1. https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1长度小于等于nums2
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        double result = 0;
        while (imin <= imax) {
            int i = (imin + imax) >> 1;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                double lMax = 0, rMin = 0;
                if (i == 0) {
                    lMax = nums2[j - 1];
                } else if (j == 0) {
                    lMax = nums1[i - 1];
                } else {
                    lMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (((m + n) & 1) == 1) {
                    result = lMax;
                    break;
                }

                if (i == m) {
                    rMin = nums2[j];
                } else if (j == n) {
                    rMin = nums1[i];
                } else {
                    rMin = Math.min(nums1[i], nums2[j]);
                }
                result = (lMax + rMin) / 2;
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
        if (n % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, n / 2) +
                    findKth(nums1, nums2, 0, 0, n / 2 + 1)) / 2.0;
        }

        return findKth(nums1, nums2, 0, 0, n / 2 + 1);
    }

    // find kth num of 2 sorted array
    private int findKth(int[] A, int[] B, int startA, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int halfKthOfA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfKthOfA < halfKthOfB) {
            return findKth(A, B, startA + k / 2, startB, k - k / 2);
        } else {
            return findKth(A, B, startA, startB + k / 2, k - k / 2);
        }
    }
}
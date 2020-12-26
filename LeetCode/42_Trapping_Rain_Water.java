// 1. O(N) - O(1)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int n = height.length, result = 0;
        int l = 0, r = n - 1;
        int lmax = height[l], rmax = height[r];
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax) {
                result += lmax - height[l];
                l++;
            } else {
                result += rmax - height[r];
                r--;
            }
        }

        return result;
    }
}
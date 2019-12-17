class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lmax = new int[height.length];
        lmax[0] = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            lmax[i + 1] = Math.max(lmax[i], height[i]);
        }
        int max = 0, area = 0;
        for (int i = height.length - 1; i >= 0; --i) {
            area += Math.min(max, lmax[i]) > height[i] ? Math.min(max, lmax[i]) - height[i] : 0;
            max = Math.max(max, height[i]);
        }
        return area;
    }
}
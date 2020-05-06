class Solution {
    public int climbStairs(int n) {
        int pprev = 0, prev = 1, result = 0;
        for (int i = 0; i < n; i++) {
            result = pprev + prev;
            pprev = prev;
            prev = result;
        }
        return result;
    }
}

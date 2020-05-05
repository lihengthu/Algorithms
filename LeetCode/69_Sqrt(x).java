class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end > x / end) {
            return start;
        }
        return end;
    }
}
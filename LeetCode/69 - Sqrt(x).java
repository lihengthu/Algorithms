Analysis: 
    1. 

Solutions:

1. Binary Search
class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}

2. Newton's Method
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}
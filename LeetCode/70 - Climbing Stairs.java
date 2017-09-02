Analysis: 
    1. Fabinacci

Solutions:

1. 代码简洁
class Solution {
    public int climbStairs(int n) {
        int i = 1, j = 1;
        while (n-- > 0) {
            j += i;
            i = j - i;
        }
        return i;
    }
}
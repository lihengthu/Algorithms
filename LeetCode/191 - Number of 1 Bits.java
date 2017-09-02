Analysis: 
	1. 
Solutions:

1. 经典解法
public class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0){
            ++cnt;
            n &= n - 1;
        }
        return cnt;
    }
}
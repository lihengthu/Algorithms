Analysis:
    1. 
Solutions:
1. 
public class Solution {
    public int RectCover(int target) {
        if (target == 0) return 0;
        int i = 1, j = 1;
        while (target-- > 0) {
            j += i;
            i = j - i;
        }
        return i;
    }
}
Analysis:
    1. 基本功，开胃菜；

Solutions:
1. Offer 思路
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) return false;
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target)
                return true;
            if (array[row][col] < target)
                ++row;
            else --col;
        }
        return false;
    }
}
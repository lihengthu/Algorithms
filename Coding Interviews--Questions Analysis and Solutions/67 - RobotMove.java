Analysis: 
    1. 第一遍独立AC;
    2. 未在LeetCode 上找到对应;

Solutions:

1. 回溯法 -- 28 lines
public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) return 0;
        boolean[][] visited = new boolean[rows][cols];
        return move(threshold, rows, cols, 0, 0, visited);
    }

    private int move(int threshold, int rows, int cols, int row, int col, boolean[][] visted) {
        int cnt = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visted[row][col]) {
            if (bitSum(row) + bitSum(col) <= threshold) {
                visted[row][col] = true;
                cnt = 1 + move(threshold, rows, cols, row + 1, col, visted)
                        + move(threshold, rows, cols, row - 1, col, visted)
                        + move(threshold, rows, cols, row, col + 1, visted)
                        + move(threshold, rows, cols, row, col - 1, visted);
            }
        }
        return cnt;
    }

    private int bitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
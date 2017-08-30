Analysis: 
    1. 和 N Queues 相比，此题只需要计算出种数，因此不必实际放下棋子的位置；

Solutions:

1. // HashSet 效率很低
class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diags = new HashSet<>();
    private Set<Integer> antiDiags = new HashSet<>();

    public int totalNQueens(int n) {
        return totalNQueensHelper(0, 0, n);
    }

    private int totalNQueensHelper(int row, int cnt, int n) {
        for (int col = 0; col < n; ++col) {
            if (cols.contains(col)) continue;
            int diag = row - col;
            if (diags.contains(diag)) continue;
            int antiDiag = row + col;
            if (antiDiags.contains(antiDiag)) continue;
            if (row == n - 1)
                ++cnt;
            else {
                cols.add(col);
                diags.add(diag);
                antiDiags.add(antiDiag);
                cnt = totalNQueensHelper(row + 1, cnt, n);
                cols.remove(col);
                diags.remove(diag);
                antiDiags.remove(antiDiag);
            }
        }
        return cnt;
    }
}
2. // boolean[] + global variable
class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[ 2 * n];
        boolean[] d2 = new boolean[ 2 * n];
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    private void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) ++count;
        for (int col = 0; col < n; ++col) {
            int id1 = col - row + n;
            int id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
3. // 用 位运算 代替 boolean 数组，最快的解法
/*
    常规n-queens解法, 数答案个数.
    用column标记此行之前的哪些column已经放置了queen. 棋盘坐标(row, col)对应column的第col位(LSB --> MSB, 下同).
    用diag标记此位置之前的哪些主对角线已经放置了queen. 棋盘坐标(row, col)对应diag的第(n - 1 + row - col)位.
    用antiDiag标记此位置之前的哪些副对角线已经放置了queen. 棋盘坐标(row, col)对应antiDiag的第(row + col)位.
*/
public class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        dfs(0, n, 0, 0, 0);
        return count;
    }

    private void dfs(int row, int n, int column, int diag, int antiDiag) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean isColSafe = ((1 << i) & column) == 0;
            boolean isDiagSafe = ((1 << (n - 1 + row - i)) & diag) == 0;
            boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
            if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
            }
        }
    }
}
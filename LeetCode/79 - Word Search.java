Analysis: 
    1. 我的最初思路是构造一个boolean矩阵，标示是否被占用。

Solutions:

1. JiuZhang
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word.length() == 0)
            return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean rst = find(board, i, j, word, 0);
                    if (rst)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {
        if (start == word.length())
            return true;

        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#'; // should remember to mark it
        boolean rst = find(board, i - 1, j, word, start + 1)
                || find(board, i, j - 1, word, start + 1)
                || find(board, i + 1, j, word, start + 1)
                || find(board, i, j + 1, word, start + 1);
        board[i][j] = word.charAt(start);
        return rst;
    }
}
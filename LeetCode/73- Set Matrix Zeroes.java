Analysis: 
    1. Fabinacci

Solutions:

1. JiuZhang
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean emptyRow0 = false;
        boolean emptyCol0 = false;

        for (int i = 0; i < cols; ++i) {
            if (matrix[0][i] == 0) {
                emptyRow0 = true;
                break;
            }
        }
        for (int i = 0; i < rows; ++i) {
            if (matrix[i][0] == 0) {
                emptyCol0 = true;
                break;
            }
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (emptyRow0) {
            for (int i = 0; i < cols; ++i)
                matrix[0][i] = 0;
        }
        if (emptyCol0) {
            for (int i = 0; i < rows; ++i)
                matrix[i][0] = 0;
        }
    }
}

2. Discuss - 
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean col0 = false;

        for (int i = 0; i < rows; ++i) {
            if (matrix[i][0] == 0)
                col0 = true;
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 1; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0) matrix[i][0] = 0;
        }
    }
}

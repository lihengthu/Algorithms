class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        while (n > 0) {
            if (n == 1) {
                result[x][y] = num++;
                break;
            }
            for (int i = 0; i < n - 1; ++i) {
                result[x][y++] = num++;
            }
            for (int i = 0; i < n - 1; ++i) {
                result[x++][y] = num++;
            }
            for (int i = 0; i < n - 1; ++i) {
                result[x][y--] = num++;
            }
            for (int i = 0; i < n - 1; ++i) {
                result[x--][y] = num++;
            }
            x++;
            y++;
            n = n - 2;
        }
        return result;
    }
}
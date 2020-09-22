// 1. DFS
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        for (int k = 0; k < 4; k++) {
            int iNext = i + dir[k][0], jNext = j + dir[k][1];
            if (iNext >= 0 && jNext >= 0 && iNext < m && jNext < n && grid[iNext][jNext] == '1') {
                grid[iNext][jNext] = '0';
                dfs(grid, iNext, jNext);
            }
        }
    }
}

// 2. weighted quick-union without path compression
class Solution {
    private int[] id = new int[100000];
    private int[] size = new int[100000];
    private int result = 0;

    private int find(int p) {
        int child, temp;
        child = p;
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            result--;
            if (size[pRoot] < size[qRoot]) {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                id[i * n + j] = i * n + j;
                if (grid[i][j] == '1') {
                    result++;
                    size[i * n + j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(i * n + j, i * n + n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return result;
    }
}

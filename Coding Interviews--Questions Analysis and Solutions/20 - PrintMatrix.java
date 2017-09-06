Analysis:


Solutions:
1. // 自己写的 -- 自己都思维习惯 -- 关键在最后两个循环
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int rows = matrix.length, columns = matrix[0].length;
        int circle = (Math.min(rows, columns) + 1) >> 1;

        for (int i = 0; i < circle; ++i) {
            for (int j = i; j < columns - i; ++j)
                list.add(matrix[i][j]);
            for (int j = i + 1; j < rows - i; ++j)
                list.add(matrix[j][columns - i - 1]);
            for (int j = columns - i - 2; j >= i && i < rows - i - 1; --j)
                list.add(matrix[rows - i - 1][j]);
            for (int j = rows - i - 2; j >= i + 1 && i < columns - i - 1; --j)
                list.add(matrix[j][i]);
        }
        return list;
    }
}
2. LeetCode Discuss 
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++)
                res.add(matrix[rowBegin][j]);
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j++)
                res.add(matrix[j][colEnd]);
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--)
                    res.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--)
                    res.add(matrix[j][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
}

3. LeetCode Discuss
vector<int> spiralOrder(vector<vector<int>>& matrix) {
    vector<vector<int> > dirs{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    vector<int> res;
    int nr = matrix.size();     if (nr == 0) return res;
    int nc = matrix[0].size();  if (nc == 0) return res;
    
    vector<int> nSteps{nc, nr-1};
    
    int iDir = 0;   // index of direction.
    int ir = 0, ic = -1;    // initial position
    while (nSteps[iDir%2]) {
        for (int i = 0; i < nSteps[iDir%2]; ++i) {
            ir += dirs[iDir][0]; ic += dirs[iDir][1];
            res.push_back(matrix[ir][ic]);
        }
        nSteps[iDir%2]--;
        iDir = (iDir + 1) % 4;
    }
    return res;
}
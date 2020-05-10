Solutions:

1. Binary Search Twice
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0, r = rows;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l - 1 == -1) {
            return false;
        }
        rows = l - 1;
        l = 0;
        r = cols;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[rows][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l < cols && matrix[rows][l] == target) {
            return true;
        }
        return false;
    }
}

2. 从右上角二分, basic idea
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target)
                ++row;
            else --col;
        }
        return false;
    }
}

3. //Don't treat it as a 2D matrix, just treat it as a sorted list
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
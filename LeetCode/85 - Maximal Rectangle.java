Analysis: 
	1. 

Solutions:

1. Based on Maximum Rectangle in Histogram
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == '1') {
                height[i] = 1;
            }
        }
        int rest = largestRectangleArea(height);
        for (int i = 1; i < matrix.length; ++i) {
            resetHeight(matrix, height, i);
            rest = Math.max(rest, largestRectangleArea(height));
        }
        return rest;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[idx][i] == '1')
                height[i] += 1;
            else height[i] = 0;
        }
    }

    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
}

2. DP - https://discuss.leetcode.com/topic/6650/share-my-dp-solution
height counts the number of successive '1's above (plus the current one). 
The value of left & right means the boundaries of the rectangle 
which contains the current point with a height of value height.
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int max = 0;
        for (int i = 0; i < m; ++i) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; ++j)
                max = Math.max(max, (right[j] - left[j]) * height[j]);
        }
        return max;
    }
}
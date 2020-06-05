class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n + 1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = i == 0 ? 1 : heights[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(heights[i]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, result = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                result = Math.max(result, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return result;
    }
}
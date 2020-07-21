// 1. Iterative
class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        int result = 0, curSum = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curSum = curSum * 10 + curr.val;
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right != null && prev != curr.right) {
                curr = curr.right;
            } else {
                prev = curr;
                stack.pop();
                if (curr.left == null && curr.right == null) {
                    result += curSum;
                }
                curSum /= 10;
                curr = null;
            }
        }

        return result;
    }
}

// 2. Recursive
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }

        int sum = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
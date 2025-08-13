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

// 基于层次遍历,更好理解
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
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
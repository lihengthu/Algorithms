// 1. Recursive
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}

// 2. Post-order
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        int curSum = 0;
        TreeNode cur = root, prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                curSum += cur.val;
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.left == null && cur.right == null && curSum == sum) {
                return true;
            }
            if (cur.right != null && prev != cur.right) {
                cur = cur.right;
            } else {
                prev = cur;
                stack.pop();
                curSum -= cur.val;
                cur = null;
            }
        }

        return false;
    }
}

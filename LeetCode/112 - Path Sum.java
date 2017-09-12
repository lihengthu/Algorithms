Analysis: 

Solutions:
1. 递归
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.left, sum ) || hasPathSum(root.right, sum);
    }
}

2. 非递归
https://discuss.leetcode.com/topic/7476/my-java-no-recursive-method
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() && root != null) {
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                if (cur.val == sum) return true;
            }
            if (cur.right != null) {
                cur.right.val = cur.val + cur.right.val;
                stack.push(cur.right);
            }
            if (cur.left != null) {
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false;
    }
}
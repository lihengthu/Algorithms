class Solution {

    public boolean isBalanced(TreeNode root) {
        return maxHeight(root) != -1;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}

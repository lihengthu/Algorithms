// 1. Recursive
class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (first == null && root.val < prev.val) {
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}

// 2. Iterative
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null && root.val < prev.val) {
                first = prev;
            }
            if (first != null && root.val < prev.val) {
                second = root;
            }
            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

// 3. Morris Traveral - O(1) space
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode preIn = new TreeNode(Integer.MIN_VALUE);

        while (root != null) {
            if (root.left == null) {
                if (root.val < preIn.val) {
                    if (first == null) {
                        first = preIn;
                        second = root;
                    } else {
                        second = root;
                    }
                }
                preIn = root;
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    if (root.val < preIn.val) {
                        if (first == null) {
                            first = preIn;
                            second = root;
                        } else {
                            second = root;
                        }
                    }
                    preIn = root;
                    prev.right = null;
                    root = root.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

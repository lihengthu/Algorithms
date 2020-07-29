class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right != null && prev != curr.right) {
                curr = curr.right;
            } else {
                prev = curr;
                result.add(curr.val);
                stack.pop();
                curr = null;
            }
        }

        return result;
    }
}

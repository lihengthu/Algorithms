class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        // prev用来记录右孩子是否访问过
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
                // 千万别忘置curr为null
                curr = null;
            }
        }

        return result;
    }
}

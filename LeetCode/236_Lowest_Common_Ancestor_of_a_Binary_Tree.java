// 1. Recursive
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}

// Iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.offer(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
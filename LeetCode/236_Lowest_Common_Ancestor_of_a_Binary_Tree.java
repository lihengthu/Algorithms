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

class Solution {
    // 不用Map<TreeNode, TreeNode> 可以避免根节点的<root, null>
    public Map<Integer, TreeNode> parent = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        // 先找p的全部父节点
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        // 自底向上看q的父节点
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return root;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
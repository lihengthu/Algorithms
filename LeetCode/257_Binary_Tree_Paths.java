class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root, "", res);

        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val + "");
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb.toString(), res);
            dfs(root.right, sb.toString(), res);
        }
    }
}
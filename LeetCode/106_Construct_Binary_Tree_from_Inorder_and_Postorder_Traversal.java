class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    private TreeNode build(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost, Map<Integer, Integer> inMap) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[endPost]);
        int rootId = inMap.get(postorder[endPost]);
        int count = rootId - startIn;

        root.left = build(inorder, startIn, rootId - 1, postorder, startPost, startPost + count - 1, inMap);
        root.right = build(inorder, rootId + 1, endIn, postorder, startPost + count, endPost - 1, inMap);

        return root;
    }
}
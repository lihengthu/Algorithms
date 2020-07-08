class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode construct(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn, Map<Integer, Integer> inMap) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int rootId = inMap.get(preorder[startPre]);
        int count = rootId - startIn;

        root.left = construct(preorder, startPre + 1, startPre + count, inorder, startIn, rootId - 1, inMap);
        root.right = construct(preorder, startPre + count + 1, endPre, inorder, rootId + 1, endIn, inMap);

        return root;
    }
}
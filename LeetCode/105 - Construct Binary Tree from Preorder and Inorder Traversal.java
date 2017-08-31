Analysis: 

Solutions:

1. 递归
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        for (int i = startIn; i <= endIn; ++i) {
            if (inorder[i] == preorder[startPre]) {
                root.left = buildTreeCore(preorder, startPre + 1, startPre + i - startIn, inorder, startIn, i - 1);
                root.right = buildTreeCore(preorder, startPre + i - startIn + 1, endPre, inorder, i + 1, endIn);
            }
        }
        return root;
    }
}

2. // with Cache, faster
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeCore(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn, Map<Integer, Integer> map) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        int inIndex = map.get(preorder[startPre]);
        root.left = buildTreeCore(preorder, startPre + 1, startPre + inIndex - startIn, inorder, startIn, inIndex - 1, map);
        root.right = buildTreeCore(preorder, startPre + inIndex - startIn + 1, endPre, inorder, inIndex + 1, endIn, map);
        return root;
    }
}
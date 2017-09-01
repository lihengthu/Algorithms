Analysis: 
	1. 常规递归方法；
	2. 有迭代解法，待看
Solutions:

1. 递归
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost, Map<Integer, Integer> map) {
        if (startIn > endIn || startPost > endPost)
            return null;
        TreeNode root = new TreeNode(postorder[endPost]);
        int inIndex = map.get(postorder[endPost]);
        root.left = helper(inorder, startIn, inIndex - 1, postorder, startPost, startPost + inIndex - startIn - 1, map);
        root.right = helper(inorder, inIndex + 1, endIn, postorder, startPost + inIndex - startIn, endPost - 1, map);
        return root;
    }
}
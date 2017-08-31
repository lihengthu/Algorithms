Analysis:
    1. 基本功，开胃菜；

Solutions:
1. // 关键是找准位置，可结合图例计算；
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;
        return reConstructBTCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBTCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; ++i) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBTCore(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBTCore(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}
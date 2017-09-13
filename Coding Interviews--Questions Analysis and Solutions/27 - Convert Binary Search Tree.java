Analysis:


Solutions:
1. 首先要想到中序遍历
public class Solution {
    TreeNode leftHead = null, rightHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (rightHead == null)
            leftHead = rightHead = pRootOfTree;
        else {
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return leftHead;
    }
}
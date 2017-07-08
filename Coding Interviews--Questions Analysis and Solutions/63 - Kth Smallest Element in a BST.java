Analysis: 
    1. 无论是递归还是非递归，都是中序遍历，因为中序遍历二叉排序树得到的遍历序列是递增排序的。
    2. LeetCode 230, Follow-Up 是BST被频繁修改，比如经常有插入/删除操作。
    3. 必须从原理上理解各种遍历的算法。
Solutions:

1. 中序遍历 - 递归版本
public class Solution {
    int index = 0;
 
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null)
                return node;
            ++index;
            if (index == k)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null)
                return node;
        }
        return null;
    }
}

2. 中序遍历 - 迭代版本 - Stack
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode p = pRoot, kthNode = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            ++index;
            if (index == k) return node;
            p = node.right;
        }
        return kthNode;
    }
}

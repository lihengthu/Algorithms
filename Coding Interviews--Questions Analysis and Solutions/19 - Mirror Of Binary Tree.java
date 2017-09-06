Analysis:


Solutions:
1. 《剑指Offer》 -- 递归
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

2. 非递归，用Stack、Quuue 都行，层次遍历
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode p = stack.pop();
            if (p.left != null || p.right != null){
                TreeNode temp = p.left;
                p.left = p.right;
                p.right = temp;
            }
            if (p.left != null)
                stack.push(p.left);
            if (p.right != null)
                stack.push(p.right);
        }
    }
}
Analysis: 
    1. 和《剑指Offer》上的稍微不同
Solutions:

1. 短路原理
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return hasSubtree(s,t) ||isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean hasSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || (s.val != t.val))
            return false;
        return hasSubtree(s.left, t.left) && hasSubtree(s.right, t.right);
    }
}

2. preOrder String 速度并不快
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s);
        String tpreorder = generatepreorderString(t);

        return spreorder.contains(tpreorder);
    }

    public String generatepreorderString(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while (!stacktree.isEmpty()) {
            TreeNode popelem = stacktree.pop();
            if (popelem == null)
                sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
            else
                sb.append("," + popelem.val);
            if (popelem != null) {
                stacktree.push(popelem.right);
                stacktree.push(popelem.left);
            }
        }
        return sb.toString();
    }
}
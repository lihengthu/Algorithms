Analysis: 关键在于如何判断是否对称，无论是前序、中序、后序、层次遍历，定义其对称的遍历算法，
即先遍历右子结点再遍历左子结点，看这两个序列是否一样。

Solutions:

1. 前序遍历 - 递归版本
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalCore(pRoot, pRoot);
    }
 
    private boolean isSymmetricalCore(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSymmetricalCore(root1.left, root2.right) && isSymmetricalCore(root1.right, root2.left);
    }
}

2. 前序遍历 - 迭代版本 - Stack
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode p1 = pRoot, p2 = pRoot;
        while ((p1 != null && p2 != null) || (!s1.isEmpty() && !s2.isEmpty())) {
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) return false;
                s1.push(p1);
                s2.push(p2);
                p1 = p1.left;
                p2 = p2.right;
            }
            p1 = s1.pop();
            p2 = s2.pop();
            p1 = p1.right;
            p2 = p2.left;
        }
        if (!s1.isEmpty() || !s2.isEmpty())
            return false;
        if (p1 != null || p2 != null)
            return false;
        return true;
    }
 
}

3. 层次遍历 - Queue
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode left, right;
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            left = q1.poll();
            right = q2.poll();
            if (null == left && null == right) continue;
            if (null == left || null == right) return false;
            if (left.val != right.val) return false;
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }
}
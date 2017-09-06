Analysis:


Solutions:
1. 层次遍历 BFS
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            result.add(t.val);
            if (t.left != null)
                queue.offer(t.left);
            if (t.right != null)
                queue.offer(t.right);
        }
        return result;
    }
}
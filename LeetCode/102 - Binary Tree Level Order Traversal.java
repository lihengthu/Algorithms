Analysis: 
    1. 
Solutions:
1. Discuss
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < levelNum; ++i) {
                TreeNode t = queue.poll();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
                sublist.add(t.val);
            }
            result.add(sublist);
        }
        return result;
    }
}
2. 
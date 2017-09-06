Analysis: 

Solutions:

1. Queue + add
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; ++i) {
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            result.add(0, list);
            list = new ArrayList<>();
        }
        return result;
    }
}

2. 递归
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelMaker(result, root, 0);
        return result;
    }

    private void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size())
            list.add(0, new LinkedList<>());
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
Analysis: 
    1. 

Solutions:
1. Discuss - BFS
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }

    private void travel(TreeNode curr, List<List<Integer>> result, int level) {
        if (curr == null) return;
        if (result.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }
        List<Integer> collection = result.get(level);
        if ((level & 1) == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        travel(curr.left, result, level + 1);
        travel(curr.right, result, level + 1);
    }
}

2. 双栈 - 自己写的
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root);
        boolean flag = true;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (flag) {
                while (!s1.isEmpty()) {
                    TreeNode t = s1.pop();
                    list.add(t.val);
                    if (t.left != null)
                        s2.push(t.left);
                    if (t.right != null)
                        s2.push(t.right);
                }
                flag = false;
            } else {
                while (!s2.isEmpty()) {
                    TreeNode t = s2.pop();
                    list.add(t.val);
                    if (t.right != null)
                        s1.push(t.right);
                    if (t.left != null)
                        s1.push(t.left);
                }
                flag = true;
            }
            result.add(list);
        }
        return result;
    }
}
3. One Queue
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean order = true;
        int size = 1;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order)
                    list.add(n.val);
                else list.add(0,n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            result.add(list);
            size = q.size();
            order = !order;
        }
        return result;
    }
}
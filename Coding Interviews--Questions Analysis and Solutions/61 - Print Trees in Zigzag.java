Analysis: 
    1. 和 LeetCode 返回类型稍有不同
Solutions:

1. 《剑指Offer》解法 -- 双栈
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
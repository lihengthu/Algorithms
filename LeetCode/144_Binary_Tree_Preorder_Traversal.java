// 只是一种Iterative的写法
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return result;
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);

                // 遍历顺序等于入栈顺序
                res.add(curr.val);

                curr = curr.left;
            }

            curr = s.pop();
            curr = curr.right;
        }

        return res;
    }
}
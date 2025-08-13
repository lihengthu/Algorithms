public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = stack.peek(), node = curr;
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


class BSTIterator {
    public Map<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode curr = new TreeNode(-1);
    public TreeNode minNode = null, prev = null;

    public BSTIterator(TreeNode root) {
        dfs(root);
        map.put(curr, minNode);
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }

        int res = map.get(curr).val;
        curr = map.get(curr);

        return res;
    }

    public boolean hasNext() {
        return map.containsKey(curr) && map.get(curr) != null;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        // 中序遍历
        if (minNode == null || root.val < minNode.val) {
            minNode = root;
        }

        if (prev != null) {
            map.put(prev, root);
        }
        prev = root;

        dfs(root.right);
    }
}


// 1. Iterative
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int curSum = 0;
        TreeNode curr = root, prev = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                list.add(curr.val);
                curSum += curr.val;
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right != null && prev != curr.right) {
                curr = curr.right;
            } else {
                prev = curr;
                TreeNode temp = stack.pop();
                if (temp.left == null && temp.right == null && curSum == sum) {
                    result.add(new ArrayList<>(list));
                }
                curSum -= curr.val;
                list.remove(list.size() - 1);
                curr = null;
            }
        }

        return result;
    }
}

// 2. Recursive
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findSum(root, sum, result, path);
        return result;
    }

    private void findSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        findSum(root.left, sum, result, path);
        findSum(root.right, sum, result, path);
        path.remove(path.size() - 1);
    }
}
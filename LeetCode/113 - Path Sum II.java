Analysis: 

Solutions:
1. 递归
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        pathFind(new ArrayList<>(), root, 0, sum, results);
        return results;
    }

    private void pathFind(List<Integer> path,
                          TreeNode root,
                          int currSum,
                          int sum,
                          List<List<Integer>> results) {
        if (root == null) return;
        path.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == sum)
            results.add(new ArrayList<>(path));
        pathFind(path, root.left, currSum, sum, results);
        pathFind(path, root.right, currSum, sum, results);
        path.remove(path.size() - 1);
    }
}
Analysis:


Solutions:
1. 回溯(backtracking) 是 DFS中间的一步，理解Reference，回退到之前的状态。
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        traverse(new ArrayList<Integer>(), root, 0, target, results);
        return results;
    }

    private void traverse(ArrayList<Integer> path,
                          TreeNode root,
                          int currSum,
                          int target,
                          ArrayList<ArrayList<Integer>> results) {
        if (root == null) return;
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && currSum == target)
            results.add(new ArrayList<>(path));
        traverse(path, root.left, currSum, target, results);
        traverse(path, root.right, currSum, target, results);
        path.remove(path.size() - 1);
    }
}
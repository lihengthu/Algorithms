Analysis: 
    
Solutions:

1. DFS
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }
}

2. /*HashMap - similar as Two sum, using HashMap to store ( key : the prefix sum, value : 
how many ways get to this prefix sum) , 
and whenever reach a node, we check if prefix sum - target exists in hashmap or not, 
if it does, we added up the ways of prefix sum - target into res.
For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, 
let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
链接：https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root,
                       int currSum,
                       int target,
                       Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
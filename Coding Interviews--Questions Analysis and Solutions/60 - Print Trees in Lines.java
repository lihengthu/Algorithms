Analysis: 

Solutions:

1. 《剑指Offer》解法 -- Queue + 两个变量 toBePrint 和 nextLevel
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return res;
        queue.offer(pRoot);
        int nextLevel = 0, toBePrint = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            list.add(p.val);
            if (null != p.left) {
                queue.offer(p.left);
                ++nextLevel;
            }
            if (null != p.right) {
                queue.offer(p.right);
                ++nextLevel;
            }
            --toBePrint;
            if (toBePrint == 0) {
                res.add(list);
                toBePrint = nextLevel;
                nextLevel = 0;
                list = new ArrayList<>();
            }
        }
        return res;
    }
}

2. 牛客网 Discuss -- 18 lines
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        while (!q.isEmpty()) {
            int lo = 0, hi = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (lo++ < hi) {
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(list);
        }
        return res;
    }
}
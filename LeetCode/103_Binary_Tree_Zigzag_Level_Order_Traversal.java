class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> s = new LinkedList<>();

        // 初始化
        s.offer(root);
        int level = 0;
        while (!s.isEmpty()) {
            int cnt = s.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cnt; ++i) {
                TreeNode curr = s.poll();

                // 根据层数奇偶，判断在List首 or 尾插入
                if (level % 2 == 0) {
                    list.add(curr.val);
                } else {
                    list.add(0, curr.val);
                }

                if (curr.left != null) {
                    s.offer(curr.left);
                }
                if (curr.right != null) {
                    s.offer(curr.right);
                }
            }

            res.add(list);
            level++;
        }

        return res;
    }
}
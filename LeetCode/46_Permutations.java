class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, res, new ArrayList<>(), visited);

        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;

                dfs(nums, res, curr, visited);

                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
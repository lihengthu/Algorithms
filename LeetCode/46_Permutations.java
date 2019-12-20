class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, permutation, result);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
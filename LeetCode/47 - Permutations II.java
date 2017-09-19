Analysis: 
    1. Follow-up 数组中含有重复数组 

Solutions:

1. 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums,
                     boolean[] used,
                     List<Integer> list,
                     List<List<Integer>> results) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, results);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
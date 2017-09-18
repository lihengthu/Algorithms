Analysis: 
    1. 

Solutions:

1. 查重后
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        backtrack(results, new ArrayList<>(), nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> list,
                           int[] nums) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtrack(results, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
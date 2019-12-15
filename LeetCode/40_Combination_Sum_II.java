class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        helper(candidates, target, 0, combination, result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (candidates[i] > target) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
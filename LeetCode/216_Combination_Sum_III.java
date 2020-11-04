class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combine(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int k, int sum, int start, List<Integer> list, List<List<Integer>> result) {
        if (k == 0 && sum == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9 && i <= sum; i++) {
            list.add(i);
            combine(k - 1, sum - i, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}

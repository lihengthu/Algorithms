class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(result, tmp, k, n, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tmp, int k, int n, int index) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i <= n; i++) {
            tmp.add(i);
            helper(result, tmp, k, n, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
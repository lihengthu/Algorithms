Analysis: 
    1. Fabinacci

Solutions:

1. JiuZhang
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        helper(rst, sol, n, k, 1);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> sol, int n, int k, int start) {
        if (sol.size() == k) {
            rst.add(new ArrayList<>(sol));
            return;
        }
        for (int i = start; i <= n; ++i) {
            sol.add(i);
            helper(rst, sol, n, k, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}
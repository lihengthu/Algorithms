http://www.jiuzhang.com/solution/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>>	result = new ArrayList<List<Integer>>();
		if (nums == null) return result;
		if (nums.length == 0){
			result.add(new ArrayList<Integer>());
			return result;
		}
		Arrays.sort(nums);
		List<Integer> subset = new ArrayList<>();
		helper(nums, 0, subset, result);
		return result;
    }

	private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> result){
		result.add(new ArrayList<Integer>(subset));
		for (int i = startIndex; i < nums.length; ++i){
			subset.add(nums[i]);
			helper(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
	}
}

class Solution {
	public List<Integer> grayCode(int n){
		List<Integer> rest = new ArrayList<>();
		rest.add(0);
		for (int i = 0; i < n; ++i){
			int size = rest.size();
			for (int k = size - 1; k >= 0; --k){
				rest.add(rest.get(k) | 1 << i);
			}
		}
		return rest;
	}
}

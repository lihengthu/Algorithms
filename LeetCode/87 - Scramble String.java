Analysis: 
	1. 

Solutions:

1. 记忆化搜索
class Solution {
	HashMap<String, Boolean> map = new HashMap<>();

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()){
			return false;
		}
		if (map.containsKey(s1 + "#" + s2)){
			return map.get(s1 + "#" + s2);
		}
		int n = s1.length();
		if (n == 1){
			return s1.charAt(0) == s2.charAt(0);
		}
		for (int k = 1; k < n; ++k){
			if(isScramble(s1.substring(0,k),s2.substring(0,k)) &&
					isScramble(s1.substring(k,n),s2.substring(k,n))||
				isScramble(s1.substring(0,k),s2.substring(n-k,n)) &&
				isScramble(s1.substring(k,n),s2.substring(0,n - k)))
			{
				map.put(s1 + "#" + s2, true);
				return true;
			}
		}
		map.put(s1 + "#" + s2, false);
		return false;
	}
}
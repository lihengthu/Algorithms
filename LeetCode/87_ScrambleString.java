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

2. 递推
class Solution {
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            
        for (int len = 2; len <= n; ++len)
            for (int x = 0; x < n && x + len <= n; ++x)
                for (int y = 0; y < n && y + len <=n; ++y)
                    for (int k= 1; k < len; ++k)
                    dp[x][y][len] |= dp[x][y][k] && dp[x + k][y + k][len - k]
                    || dp[x][y + len - k][k] && dp[x + k][y][len - k];
    
        return dp[0][0][n];
    }
}
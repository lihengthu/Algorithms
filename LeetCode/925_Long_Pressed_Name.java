1.
class Solution {
    public String predictPartyVictory(String senate) {
		int n =  senate.length();
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for(int i = 0; i < n; ++i){
			if (senate.charAt(i) == 'R')
				q1.offer(i);
			else q2.offer(i);
		}
		while(!q1.isEmpty() && !q2.isEmpty()){
			int r = q1.poll();
			int d = q2.poll();
			if (r < d)
				q1.offer(r + n);
			else q2.offer(d + n);
		}
		return q1.isEmpty() ? "Dire" : "Radiant";
    }
}

2. Two Pointers
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j){
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                ++i;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)){
                return false;
            }
        }
        return i == m;
    }
}

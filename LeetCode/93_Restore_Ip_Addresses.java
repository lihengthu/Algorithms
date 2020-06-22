import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 4 || s.length() > 12){
			return result;
		}
		List<String> list = new ArrayList<>();
		helper(result, list, s, 0);
		return result;
    }

	private void helper(List<String> result, List<String> list, String s, int start){
		if (list.size() == 4){
			if (start == s.length()){
				StringBuilder sb = new StringBuilder();
				for (String tmp : list){
					sb.append(tmp);
					sb.append(".");
				}
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
				return;
			}
		}
		for (int i = start; i < s.length() && i < start + 3; ++i){
			String tmp = s.substring(start, i + 1);
			if (isValid(tmp)){
				list.add(tmp);
				helper(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isValid(String s){
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.valueOf(s);
		return num >=0 && num <= 255;
	}
}

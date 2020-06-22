// 1. Backtracking
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length() && i < start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if (isValid(temp)) {
                list.add(temp);
                backtrack(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.valueOf(s);
        return num >= 0 && num <= 255;
    }
}

// 2. DFS
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        dfs(s, 0, 0, "", result);
        return result;
    }

    private void dfs(String s, int pos, int dot, String tString, List<String> result) {
        if (dot > 3) {
            return;
        }
        if (pos == s.length()) {
            if (dot == 3) {
                String[] nums = tString.split("\\.");
                for (String num : nums) {
                    if (num.length() > 1 && num.charAt(0) == '0') {
                        return;
                    }
                    if (Integer.valueOf(num) > 255) {
                        return;
                    }
                }
                result.add(tString);
                return;
            }
            return;
        }

        // pos后不加点的情况
        dfs(s, pos + 1, dot, tString + s.charAt(pos), result);

        // post后加点的情况
        if (pos < s.length() - 1) {
            dfs(s, pos + 1, dot + 1, tString + s.charAt(pos) + '.', result);
        }
    }
}
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        map.put("", new ArrayList<>());
        map.get("").add("");

        return dfs(s, dict, map);
    }

    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<>();
        for (int len = 1; len <= s.length(); len++) {
            String left = s.substring(0, len);
            String right = s.substring(len);
            if (dict.contains(left)) {
                List<String> rightList = dfs(right, dict, map);
                for (String item : rightList) {
                    if (item == "") {
                        list.add(left);
                    } else {
                        list.add(left + " " + item);
                    }
                }
            }
        }
        map.put(s, list);

        return list;
    }
}
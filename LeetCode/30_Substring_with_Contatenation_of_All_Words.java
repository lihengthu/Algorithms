class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> toFind = new HashMap<>();
        Map<String, Integer> found = new HashMap<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int m = words.length, n = words[0].length();
        for (String word : words) {
            toFind.put(word, toFind.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - m * n; i++) {
            found.clear();
            int j = 0;
            for (; j < m; j++) {
                int k = i + j * n;
                String word = s.substring(k, k + n);
                if (!toFind.containsKey(word)) {
                    break;
                }
                found.put(word, found.getOrDefault(word, 0) + 1);
                if (found.get(word) > toFind.get(word)) {
                    break;
                }
            }
            if (j == m) {
                result.add(i);
            }
        }

        return result;
    }
}

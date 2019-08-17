class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> toFound = new HashMap<>();
        HashMap<String, Integer> found = new HashMap<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0){
            return result;
        }
        int m = words.length, n = words[0].length();
        for (int i = 0; i < m; ++i) {
            if (!toFound.containsKey(words[i])) {
                toFound.put(words[i], 1);
            } else {
                toFound.put(words[i], toFound.get(words[i]) + 1);
            }
        }
        for (int i = 0; i <= s.length() - m * n; ++i){
            found.clear();
            int j = 0;
            for (; j < m; ++j){
                int k = i + j * n;
                String stub = s.substring(k, k + n);
                if (!toFound.containsKey(stub)){
                    break;
                }
                if (!found.containsKey(stub)){
                    found.put(stub, 1);
                } else {
                    found.put(stub, found.get(stub) + 1);
                }
                if (found.get(stub) > toFound.get(stub)){
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
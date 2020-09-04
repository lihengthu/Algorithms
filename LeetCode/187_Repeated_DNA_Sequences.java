class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String target = s.substring(i, i + 10);
            map.put(target, map.getOrDefault(target, 0) + 1);
            if (map.get(target) == 2) {
                result.add(target);
            }
        }

        return result;
    }
}

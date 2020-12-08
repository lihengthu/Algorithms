class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxCount = 0, maxLen = 0;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, map.get(ch));
            while (r - l + 1 - maxCount > k) {
                char lch = s.charAt(l);
                map.put(lch, map.get(lch) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
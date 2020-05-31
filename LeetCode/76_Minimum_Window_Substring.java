class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int l = 0, minL = 0, minLen = s.length() + 1, cnt = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    cnt++;
                }
                while (cnt == t.length()) {
                    if (r - l + 1 < minLen) {
                        minL = l;
                        minLen = r - l + 1;
                    }
                    char lch = s.charAt(l);
                    if (map.containsKey(lch)) {
                        map.put(lch, map.get(lch) + 1);
                        if (map.get(lch) > 0) {
                            cnt--;
                        }
                    }
                    l++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minL, minL + minLen);
    }
}
Analysis: 
    1. 

Solutions:

1. HashMap 而不是Set，因为words中可能会有重复单词; Discuss中原代码不能AC，Bug位于第15行for循环中
import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (map.containsKey(w))
                map.put(w, map.get(w) + 1);
            else map.put(w, 1);
        }

        for (int i = 0; i <= s.length() - len * words.length; ++i) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; ++j) {
                String str = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else break;
            }
        }
        return res;
    }
}
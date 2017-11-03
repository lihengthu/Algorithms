Analysis: 
    1. 

Solutions:

1. JiuZhang
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int curLen = 0, lastI = 0;
        for (int i = 0; i <= n; ++i) {
            if (i == n || curLen + words[i].length() + i - lastI > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int spaceCount = maxWidth - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == n) {
                    for (int j = lastI; j < i; ++j) {
                        sb.append(words[j]);
                        if (j != i - 1)
                            appendSpace(sb, 1);
                    }
                    appendSpace(sb, maxWidth - sb.length());
                } else {
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; ++j) {
                        sb.append(words[j]);
                        if (j != i - 1)
                            appendSpace(sb, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                    }
                }
                result.add(sb.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < n)
                curLen += words[i].length();
        }
        return result;
    }

    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; ++i)
            sb.append(' ');
    }
}
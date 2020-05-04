class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordsCnt = words.length;
        int curLen = 0, lastIndex = 0;
        for (int i = 0; i <= wordsCnt; i++) {
            // 判断单行是否允许再放一个单词
            if (i == wordsCnt || curLen + words[i].length() + i - lastIndex > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int spaceCnt = maxWidth - curLen;
                int spaceSlots = i - lastIndex - 1;
                if (spaceSlots == 0 || i == wordsCnt) {
                    for (int j = lastIndex; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, 1);
                        }
                    }
                    appendSpace(sb, maxWidth - sb.length());
                } else {
                    int spaceEach = spaceCnt / spaceSlots;
                    int spaceExtra = spaceCnt % spaceSlots;
                    for (int j = lastIndex; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, spaceEach + (j - lastIndex < spaceExtra ? 1 : 0));
                        }
                    }
                }
                result.add(sb.toString());
                lastIndex = i;
                curLen = 0;
            }
            if (i < wordsCnt) {
                curLen += words[i].length();
            }
        }
        return result;
    }
    private void appendSpace(StringBuilder sb, int cnt) {
        for (int i = 0; i < cnt; i++) {
            sb.append(' ');
        }
    }
}
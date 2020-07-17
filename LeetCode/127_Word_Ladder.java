class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Set<String> dict = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);

        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return length;
                }
                for (String next : getNeighbors(word, dict)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    set.add(next);
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbor = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] sc = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                sc[i] = c;
                String next = String.valueOf(sc);
                if (dict.contains(next) && !word.equals(next)) {
                    neighbor.add(next);
                }
            }
        }

        return neighbor;
    }
}
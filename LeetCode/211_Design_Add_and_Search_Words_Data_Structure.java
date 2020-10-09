class WordDictionary {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        int length = word.length();

        TrieNode p = root;
        for (int level = 0; level < length; level++) {
            int index = word.charAt(level) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int level, TrieNode curr) {
        if (level == word.length()) {
            return curr != null && curr.isEndOfWord;
        }
        if (curr == null) {
            return false;
        }
        int length = word.length();

        char ch = word.charAt(level);
        if (ch == '.') {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (searchHelper(word, level + 1, curr.children[i])) {
                    return true;
                }
            }
        } else {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
            return searchHelper(word, level + 1, curr);
        }

        return false;
    }
}

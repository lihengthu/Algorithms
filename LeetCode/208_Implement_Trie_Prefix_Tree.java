class Trie {

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

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode p = root;
        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isEndOfWord = true;
    }

    public boolean search(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode p = root;
        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        return (p != null && p.isEndOfWord);
    }

    public boolean startsWith(String prefix) {
        int level;
        int length = prefix.length();
        int index;

        TrieNode p = root;
        for (level = 0; level < length; level++) {
            index = prefix.charAt(level) - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        return p != null;
    }
}

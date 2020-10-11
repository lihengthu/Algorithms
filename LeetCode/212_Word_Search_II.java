class TrieNode {
    String word;
    Map<Character, TrieNode> children;

    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
}

class TrieTree {
    TrieNode root;

    public TrieTree(TrieNode node) {
        root = node;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
}

class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, i, j, tree.root, result);
            }
        }
        return result;
    }

    public void find(char[][] board, int x, int y, TrieNode root, List<String> result) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }
        TrieNode child = root.children.get(board[x][y]);
        if (child.word != null && !result.contains(child.word)) {
            result.add(child.word);
        }
        char temp = board[x][y];
        board[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if (next_x >= 0 && next_y >= 0 && next_x < board.length && next_y < board[0].length && board[next_x][next_y] != 0) {
                find(board, next_x, next_y, child, result);
            }
        }
        board[x][y] = temp;
    }
}

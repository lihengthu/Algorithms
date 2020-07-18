// BFS + DFS + backtracking
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || !wordList.contains(endWord)) {
            return result;
        }

        wordList.add(beginWord);
        Set<String> dict = new HashSet<>(wordList);
        List<String> path = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();

        buildGraph(beginWord, endWord, graph, dict);
        dfs(beginWord, endWord, graph, path, result);

        return result;
    }

    private void buildGraph(String beginWord, String endWord, Map<String, List<String>> graph, Set<String> dict) {
        Set<String> visited = new HashSet<>();
        Set<String> toVisit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        toVisit.add(beginWord);
        boolean foundEnd = false;

        while (!queue.isEmpty()) {
            visited.addAll(toVisit);
            toVisit.clear();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> neighbors = getNeighbors(word, dict);
                for (String next : neighbors) {
                    if (next.equals(endWord)) {
                        foundEnd = true;
                    }
                    if (!visited.contains(next)) {
                        if (!graph.containsKey(word)) {
                            graph.put(word, new ArrayList<>());
                        }
                        graph.get(word).add(next);
                    }
                    if (!visited.contains(next) && !toVisit.contains(next)) {
                        queue.offer(next);
                        toVisit.add(next);
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbor = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] sc = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (sc[i] == c) {
                    continue;
                }
                sc[i] = c;
                String next = String.valueOf(sc);
                if (dict.contains(next)) {
                    neighbor.add(next);
                }
            }
        }

        return neighbor;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> graph, List<String> path, List<List<String>> result) {
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else if (graph.containsKey(beginWord)) {
            for (String next : graph.get(beginWord)) {
                dfs(next, endWord, graph, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
}
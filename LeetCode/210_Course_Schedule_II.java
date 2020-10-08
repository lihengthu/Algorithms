class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }

        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] topoOrder = new int[numCourses];

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            topoOrder[index] = pos;
            index++;
            for (int i = 0; i < graph[pos].size(); i++) {
                int nextPos = graph[pos].get(i);
                inDegree[nextPos]--;
                if (inDegree[nextPos] == 0) {
                    queue.offer(nextPos);
                }
            }
        }

        return index == numCourses ? topoOrder : new int[0];
    }
}

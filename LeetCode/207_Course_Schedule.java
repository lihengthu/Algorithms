class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }

        int numChoose = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int nowPos = queue.poll();
            numChoose++;
            for (int i = 0; i < graph[nowPos].size(); i++) {
                int nextPos = graph[nowPos].get(i);
                inDegree[nextPos]--;
                if (inDegree[nextPos] == 0) {
                    queue.offer(nextPos);
                }
            }
        }

        return numChoose == numCourses;
    }
}
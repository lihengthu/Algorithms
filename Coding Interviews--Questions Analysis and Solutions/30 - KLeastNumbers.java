Analysis:


Solutions:
1. 基于快排的partition思路 - 代码长，需要改变原数组

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k <= 0)
            return results;
        sort(input, k);
        for (int i = 0; i < k; ++i)
            results.add(input[i]);
        return results;
    }

    private void sort(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        Random random = new Random();
        int ran = random.nextInt(end - start + 1) + start;
        swap(arr, ran, end);
        int pivot = arr[end], index = start;
        for (int i = start; i < end; ++i) {
            if (arr[i] < pivot) {
                swap(arr, i, index);
                ++index;
            }
        }
        swap(arr, index, end);
        return index;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
2. PriorityQueue - 堆
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k <= 0)
            return results;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; ++i) {
            if (i < k)
                pq.offer(input[i]);
            else {
                int max = pq.peek();
                if (input[i] < max) {
                    pq.poll();
                    pq.offer(input[i]);
                }
            }
        }
        while (!pq.isEmpty()) {
            results.add(pq.poll());
        }
        return results;
    }
}

3. TreeSet - 红黑树
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k <= 0)
            return results;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < input.length; ++i)
            treeSet.add(input[i]);
        for (int i = 0; i < k; ++i)
            results.add(treeSet.pollFirst());
        return results;
    }
}
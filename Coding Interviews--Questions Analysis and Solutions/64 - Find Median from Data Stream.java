Analysis: -- LeetCode 295
    1. PriorityQueue 是JDK 1.5 开始提供的新的数据接口，默认内部是 Natural Ordering, 即小顶堆，也可以自定义排序器，实现大顶堆;
    2. 数据容器采用 大顶堆 + 小顶堆，且满足: 
        (1) 两个堆得数据数目相差不超过1，这样使得中位数只会出现在两个堆的顶部;
        (2) 保证大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
    3. 采用大顶堆 + 小顶堆的时间复杂度为: 插入复杂度 O(lg n), 取中位数 O(1); 使用AVL树同样达到同样的时间复杂度，但是Java函数库没有实现的AVL树的数据结构。
Solutions:

1. 大顶堆 + 小顶堆 -- 25 lines
public class Solution {

    private PriorityQueue<Integer> min = new PriorityQueue<>();
    // Collections.reverseOrder(): Returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface.
    // private PriorityQueue<Integer> max = new PriorityQueue<>(11, Collections.reverseOrder());
    private PriorityQueue<Integer> max = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if (((min.size() + max.size()) & 1) == 0) {
            if (!max.isEmpty() && num < max.peek()) {
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        } else {
            if (!min.isEmpty() && num > min.peek()) {
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double GetMedian() {
        int size = min.size() + max.size();
        if ((size & 1) == 1)
            return (double) min.peek();
        else return new Double(min.peek() + max.peek()) / 2;
    }
}

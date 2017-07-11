Analysis: 
    1. PriorityQueue 是JDK 1.5 开始提供的新的数据接口，默认内部是 Natural Ordering, 即小顶堆，也可以自定义排序器，实现大顶堆;
    2. 数据容器采用 大顶堆 + 小顶堆，且满足: 
        (1) 两个堆得数据数目相差不超过1，这样使得中位数只会出现在两个堆的顶部;
        (2) 保证大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
    3. 采用大顶堆 + 小顶堆的时间复杂度为: 插入复杂度 O(lg n), 取中位数 O(1); 使用AVL树同样达到同样的时间复杂度，但是Java函数库没有实现的AVL树的数据结构。
    4. LeetCode Discuss 中有人用两个小顶堆来做，方法是有一个小顶堆添加的是另一个小顶堆peek()的取反，类比大顶堆。
Solutions:

1. 大顶堆 + 小顶堆 -- 15 lines
public class MedianFinder {

    public MedianFinder() {
        
    }
    
    private PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    // Collections.reverseOrder(): Returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface.
    // private PriorityQueue<Integer> max = new PriorityQueue<>(11, Collections.reverseOrder());

    // 从Java 8 可以省略初始容量，但设置一个大的默认容量时间性能要好; 比如：
    // private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(1000,Collections.reverseOrder());
    private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
        maxPQ.offer(num);
        minPQ.offer(maxPQ.poll());
        if (maxPQ.size() < minPQ.size())
            maxPQ.offer(minPQ.poll());
    }

    public double findMedian() {
        if (maxPQ.size() == minPQ.size()) return (maxPQ.peek() + minPQ.peek()) / 2.0;
        else return maxPQ.peek();
    }
}

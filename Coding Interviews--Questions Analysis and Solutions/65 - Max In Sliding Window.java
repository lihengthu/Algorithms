Analysis: 
    1. 把滑动窗口看成一个队列，但并不把窗口中的每个数值都存入队列中，而是只把可能成为滑动窗口最大值的数值存入双端队列;
    2. 双端队列中存入的是数字在数组中的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于等于滑动窗口的大小时，这个数字已经从窗口中滑出，即可以从队列中删除;
    3. 对应Leetcode 239;
Solutions:

1. 双端队列 -- 21 lines
public class Solution {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (num.length >= size && size >= 1) {
            for (int i = 0; i < size; ++i) {
                while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                    deque.pollLast();
                deque.offerLast(i);
            }
            for (int i = size; i < num.length; ++i) {
                list.add(num[deque.peekFirst()]);
                while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                    deque.pollLast();
                if (!deque.isEmpty() && deque.peekFirst() <= (i - size))
                    deque.pollFirst();
                deque.offerLast(i);
            }
            list.add(num[deque.peekFirst()]);
        }
        return list;
    }
}


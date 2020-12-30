// 注意pop函数的处理
class MyStack {

    Queue<Integer> q;
    int top = 0;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top = x;
    }

    public int pop() {
        int sz = q.size();
        while (sz > 2) {
            q.offer(q.poll());
            sz--;
        }
        top = q.peek();
        q.offer(q.poll());

        return q.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
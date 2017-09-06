Analysis:


Solutions:
1. 《剑指Offer》思路
public class Solution {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || node < minStack.peek())
            minStack.push(node);
        else minStack.push(minStack.peek());
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            minStack.pop();
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        return Integer.MIN_VALUE;
    }

    public int min() {
        return minStack.peek();
    }
}
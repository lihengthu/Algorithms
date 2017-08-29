Analysis: 
    1. 理解题意

Solutions:

1. 自己写的
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int len = 1;
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            ++len;
            fast = fast.next;
        }
        if (k % len == 0) return head;
        for (int i = 1; i < len - k % len; ++i) {
            slow = slow.next;
        }
        fast.next = head;
        ListNode resHead = slow.next;
        slow.next = null;
        return resHead;
    }
}

2. LeetCode Discuss
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int len = 1;
        ListNode newHead = head, tail = head;
        while (tail.next != null) {
            ++len;
            tail = tail.next;
        }
        tail.next = head;
        if ((k %= len) != 0) {
            for (int i = 0; i < len - k; ++i)
                tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
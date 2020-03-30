class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode dummy = head, tail = head;
        while (tail.next != null) {
            ++len;
            tail = tail.next;
        }
        tail.next = head;
        k = k % len;
        if (k != 0) {
            for (int i = 0; i < len - k; ++i) {
                tail = tail.next;
            }
        }
        dummy = tail.next;
        tail.next = null;
        return dummy;
    }
}
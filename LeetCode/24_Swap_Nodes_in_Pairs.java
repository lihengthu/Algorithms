class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head, prev = dummy;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            ListNode next = q.next;
            q.next = p;
            prev.next = q;
            p.next = next;
            prev = p;
            p = next;
        }

        return dummy.next;
    }
}
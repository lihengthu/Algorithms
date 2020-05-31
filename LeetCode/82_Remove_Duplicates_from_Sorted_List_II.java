class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head, prev = dummy;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }
            if (prev.next != p) {
                prev.next = p.next;
            } else {
                prev = p;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
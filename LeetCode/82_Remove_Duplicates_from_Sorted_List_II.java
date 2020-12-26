class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy, r = head;
        while (r != null) {
            while (r.next != null && r.val == r.next.val) {
                r = r.next;
            }
            if (l.next == r) {
                l = l.next;
            } else {
                l.next = r.next;
            }
            r = r.next;
        }

        return dummy.next;
    }
}
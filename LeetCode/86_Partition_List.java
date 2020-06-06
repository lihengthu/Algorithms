class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode ld = new ListNode(0);
        ListNode rd = new ListNode(0);
        ListNode l = ld, r = rd;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = head;
            } else {
                r.next = head;
                r = head;
            }
            head = head.next;
        }
        r.next = null;
        l.next = rd.next;
        return ld.next;
    }
}
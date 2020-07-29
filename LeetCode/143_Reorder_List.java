class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            prev = slow;
            slow = slow.next;
            prev.next = null;
        } else {
            prev.next = null;
        }

        slow = reverse(slow);

        ListNode lnext = null, rnext = null, curr = head;
        while (slow != null) {
            lnext = curr.next;
            rnext = slow.next;
            curr.next = slow;
            slow.next = lnext;
            curr = lnext;
            slow = rnext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

Analysis: 
    1. 

Solutions:

1. 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; ++i) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        if (nk == null) {
            return null;
        }
        ListNode n1 = head.next, nkplus = nk.next;
        ListNode prev = null, cur = n1;
        while (cur != nkplus) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }
}

2.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            head = reverseNextK(head, k);
        }
        return dummy.next;
    }

    private ListNode reverseNextK(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; ++i) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }
        ListNode n1 = head.next;
        ListNode prev = head, cur = n1;
        for (int i = 0; i < k; ++i) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        n1.next = cur;
        head.next = prev;
        return n1;
    }
}
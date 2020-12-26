// 1. 快慢指针
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l = head, r = head.next;
        while (r != null) {
            if (r.val != l.val) {
                l.next = r;
                l = l.next;
            }
            r = r.next;
        }
        l.next = null;
        return head;
    }
}

// 2. 九章
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
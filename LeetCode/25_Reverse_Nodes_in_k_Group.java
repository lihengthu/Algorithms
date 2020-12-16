// 1. 自己最直观的解法，从链表反转演化而来 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int times = n / k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevK = dummy, prev = null;

        for (int i = 0; i < times; i++) {
            ListNode first = head;
            for (int j = 0; j < k; j++) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            prevK.next = prev;
            first.next = head;
            prevK = first;
        }

        return dummy.next;
    }
}

// 2. 相比之下，更优雅
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin, first = curr;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}
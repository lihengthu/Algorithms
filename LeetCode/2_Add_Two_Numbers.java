1. Corner Case
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int current = 0;
            if (l1 != null) {
                current += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current += l2.val;
                l2 = l2.next;
            }
            current += carry;
            ListNode tmp = new ListNode(current % 10);
            p.next = tmp;
            p = p.next;
            carry = current / 10;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        // 多加一个prev节点，便于理解
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
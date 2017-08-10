Analysis:
	1. corner cases, 提前准备全 test cases; 

Solutions:

1. 自己写的 -- 25 lines
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy, cur = pHead;
        while (cur != null) {
            if (cur.next != null){
                if (cur.val != cur.next.val){
                    prev.next = cur;
                    prev = cur;
                    cur = cur.next;
                } else {
                    while (cur.next != null && cur.val == cur.next.val){
                        cur = cur.next;
                    }
                    cur = cur.next;
                }
            } else {
                prev.next = cur;
                prev = cur;
                break;
            }
        }
        prev.next = null;
        return dummy.next;
    }
}

// LeetCode 82 -- 15 lines 不用boolean 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            if (pre.next == cur)
                pre = pre.next;
            else pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
2. 牛客网 Discuss -- 17 lines
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode p = pHead, last = dummy;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
Analysis:


Solutions:
1. // 自己写的 -- 代码略显臃肿 -- 19 lines
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = list1, q = list2, r = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
       	// 这是链表，不用 while
        if (p != null)
            r.next = p;
        if (q != null)
            r.next = q;
        return dummy.next;
    }
}
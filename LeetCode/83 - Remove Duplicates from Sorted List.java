Analysis: 
	1. 这几个算法效率都不高，beat 15%左右;

Solutions:

1. 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val)
                p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }

}

2. Recursive Solution
湘神说，链表自带递归性质 -- 有待理解
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
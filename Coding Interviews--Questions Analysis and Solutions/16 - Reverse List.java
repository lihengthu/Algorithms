Analysis:


Solutions:
1. // 自己写的 -- 代码略显臃肿
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, p = head;
        while (p.next != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        p.next = pre;
        return p;
    }
}

2. 牛客 Discuss
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null, p = head;
        while (p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
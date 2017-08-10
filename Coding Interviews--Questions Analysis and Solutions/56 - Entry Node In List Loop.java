Analysis:


Solutions:

1. 快慢指针 -- 20 lines
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return pHead;
        ListNode slow = pHead.next;
        if (slow == null) return null;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

// 另一种编码习惯
public class Solution {
 
    ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead，p2 = pHead;
        while(p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }
}
2. 断链法 - 只适合允许修改链表的情况 -- 10 lines
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead, fast = pHead.next;
        while (fast != null) {
            slow.next = null;
            slow = fast;
            fast = fast.next;
        }
        return slow;
    }
}
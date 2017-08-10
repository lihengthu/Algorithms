Analysis: 
    1. 快慢指针
Solutions:

1. Two Pointers -- 15 lines
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head.next;
        if (slow == null) return false;
        ListNode fast = slow.next;
        while (slow != null && fast != null){
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return false;
    }
}
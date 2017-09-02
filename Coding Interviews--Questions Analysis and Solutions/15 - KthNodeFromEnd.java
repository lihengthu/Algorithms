Analysis:


Solutions:
1. // 自己写的 -- 《剑指Offer》思路
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode fast = head, slow = head;
        for (int i = 0; i < k - 1; ++i) {
            if (fast.next != null)
                fast = fast.next;
            else return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
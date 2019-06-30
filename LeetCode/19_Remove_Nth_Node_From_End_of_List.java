
Solutions: 
1.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < n; ++i) {
            if (head == null){
                return null;
            }
            head = head.next;
        }
        while (head != null){
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
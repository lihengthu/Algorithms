// 变量的命名，有助于记忆和理解算法思路

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return dummy.next;
            }
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next, nNode = mNode, postN = mNode.next;
        for (int i = m; i < n; i++) {
            if (postN == null) {
                return dummy.next;
            }
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        mNode.next = postN;
        prevM.next = nNode;

        return dummy.next;
    }
}
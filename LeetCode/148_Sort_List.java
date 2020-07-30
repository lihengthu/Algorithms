class Solution {
    public ListNode sortList(ListNode head) {
        quicksort(head, null);

        return head;
    }

    private void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private ListNode partition(ListNode start, ListNode end) {
        int pivot = start.val;
        ListNode p1 = start, p2 = start.next;
        while (p2 != end) {
            if (p2.val < pivot) {
                p1 = p1.next;
                swap(p1, p2);
            }
            p2 = p2.next;
        }
        swap(start, p1);

        return p1;
    }

    private void quicksort(ListNode start, ListNode end) {
        if (start == end) {
            return;
        }

        ListNode pt = partition(start, end);
        quicksort(start, pt);
        quicksort(pt.next, end);
    }
}

Analysis:


Solutions:
1.
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode iter = pHead;
        while (iter != null) {
            RandomListNode copy = new RandomListNode(iter.label);
            copy.next = iter.next;
            iter.next = copy;
            iter = copy.next;
        }
        iter = pHead;
        while (iter != null) {
            iter.next.random = iter.random == null ? null : iter.random.next;
            iter = iter.next.next;
        }
        iter = pHead;
        RandomListNode resHead = iter.next, backup = iter.next;
        while (iter != null) {
            iter.next = backup.next;
            iter = iter.next;
            if (iter != null) {
                backup.next = iter.next;
                backup = backup.next;
            }
        }
        return resHead;
    }
}
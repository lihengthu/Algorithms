Analysis: 

Solutions:
1. 时间O(n), 空间 O(1)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode copy = new RandomListNode(iter.label);
            copy.next = iter.next;
            iter.next = copy;
            iter = copy.next;
        }
        iter = head;
        while (iter != null) {
            iter.next.random = iter.random == null ? null : iter.random.next;
            iter = iter.next.next;
        }
        iter = head;
        RandomListNode backup = iter.next, resHead = backup;
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

2. hashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
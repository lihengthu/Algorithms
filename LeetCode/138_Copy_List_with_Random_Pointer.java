class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(0), prev = dummy, newNode;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new Node(head.val);
                map.put(head, newNode);
            }
            prev.next = newNode;
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new Node(head.random.val);
                    map.put(head.random, newNode.random);
                }
            }
            prev = newNode;
            head = head.next;
        }

        return dummy.next;
    }
}
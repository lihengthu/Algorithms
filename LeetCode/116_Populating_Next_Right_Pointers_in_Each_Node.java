class Solution {
    public Node connect(Node root) {
        Node node = root;
        while (node != null && node.left != null) {
            Node curr = node;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                curr = curr.next;
            }
            node = node.left;
        }

        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(0), prev = dummy;
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                prev.next = curr.left;
                prev = prev.next;
            }
            if (curr.right != null) {
                prev.next = curr.right;
                prev = prev.next;
            }
            curr = curr.next;
            if (curr == null) {
                prev = dummy;
                curr = dummy.next;
                dummy.next = null;
            }
        }

        return root;
    }
}
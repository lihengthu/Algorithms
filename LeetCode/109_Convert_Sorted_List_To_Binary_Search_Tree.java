// 1. Recursion + Conversion to Array
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(list.get(start));
        }

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = build(list, start, mid - 1);
        root.right = build(list, mid + 1, end);

        return root;
    }
}

// 2. Inorder Simulation
class Solution {

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        this.head = head;

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        return convert(0, len - 1);
    }

    private TreeNode convert(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) >>> 1;
        TreeNode left = convert(l, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;

        this.head = head.next;
        root.right = convert(mid + 1, r);

        return root;
    }
}

1. Byself
public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createTreeNode(nums, 0, nums.length - 1);
    }

    public TreeNode createTreeNode(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) {
            return null;
        }
        int index = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[index]);
        root.left = createTreeNode(nums, start, index - 1);
        root.right = createTreeNode(nums, index + 1, end);
        return root;
    }
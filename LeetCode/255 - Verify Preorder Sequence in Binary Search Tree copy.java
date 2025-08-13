Analysis: 

Solutions:

1. 自己写的
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return judge(preorder, 0, preorder.length - 1);
    }

    private boolean judge(int[] preorder, int start, int end) {
        if (start >= end) return true;
        int root = preorder[start];
        int index = start + 1;
        while (index <= end && preorder[index] < root)
            ++index;
        for (int i = index; i <= end; ++i)
            if (preorder[i] < root)
                return false;
        return judge(preorder, start + 1, index - 1) && judge(preorder, index, end);
    }
}

2. Discuss O(1) extra space
https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
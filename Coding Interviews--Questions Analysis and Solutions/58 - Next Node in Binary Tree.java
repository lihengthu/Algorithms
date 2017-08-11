Analysis:
	1. 分为三种情况：（1）该结点有右子树，那么下一个结点就是右子树的最左子结点; 
					 （2）没有右子树，如果该结点是它父节点的左子结点，那么下一个结点就是父节点；
					 （3）如果该节点既没有右子树，并且还是它父节点的右子结点，沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的结点。

Solutions:

1. -- 15 lines
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.next != null){
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
Analysis: 
	1. 所谓序列化指的是遍历二叉树为字符串，反序列化指的是根据字符串重新构造出二叉树;
	2. 只需记录递归版的前序遍历, 把NULL指针序列化一个特殊字符如'#',非递归solution使用BFS(层次遍历)代码较长,不适宜面试;
	3. 对应LeetCode 297, 但是LeetCode上额外的Note:
		Note:Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
	   因为对象是没办法在网络上传输的，序列化和反序列化就是为了实现网络传输，这两个过程是在两个不同的端执行，因此不能使用任何类成员变量(static).
	4. Follow-up 是LeetCode 449, 序列化反序列化BST二叉搜索树，改进后算法可以节省存储空间。

Solutions:

1. 前序遍历 - 递归
public class Solution {
    private int index = -1;

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        ++index;
        int len = str.length();
        if (index >= len)
            return null;
        String[] strArray = str.split(",");
        TreeNode node = null;
        if (!strArray[index].equals("$")) { // 判断字符串内容是否相同
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}

改进版 - 去掉成员变量
public class Solution {

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        Queue<String> values = new LinkedList<>();
        values.addAll(Arrays.asList(str.split(",")));
        return buildTree(values);
    }

    private TreeNode buildTree(Queue<String> values) {
        String val = values.poll();
        if (val.equals("$")) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(values);
            node.right = buildTree(values);
            return node;
        }
    }
}

2. BFS层次遍历 - 非递归版本(LeetCode AC,牛客 内存超限)
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
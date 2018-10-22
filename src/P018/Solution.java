package P018;

import java.util.Stack;

/**
 * Created by tonyke on 10/10/2018
 * <p>
 * 二叉树的镜像
 */
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.add(root);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            TreeNode tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }
}

package P038;

/**
 * Created by tonyke on 19/10/2018
 * 二叉树的深度
 * 思路：
 * 二叉树的基础知识了
 */
public class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = root.left != null ? TreeDepth(root.left) : 0;
        int right = root.right != null ? TreeDepth(root.right) : 0;
        return Math.max(left, right) + 1;
    }
}

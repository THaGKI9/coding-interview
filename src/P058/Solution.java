package P058;

import java.util.Stack;

/**
 * Created by tonyke on 12/10/2018
 */


public class Solution {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSame(TreeNode operand1, TreeNode operand2) {
        if (operand1 == null && operand2 == null) return true;
        if (operand1 != null && operand2 != null) {
            return operand1.val == operand2.val
                    && isSame(operand1.left, operand2.right)
                    && isSame(operand1.right, operand2.left);
        }

        return false;
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return isSame(pRoot.left, pRoot.right);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        TreeNode root = new TreeNode(8,
                new Solution.TreeNode(6,
                        new Solution.TreeNode(5),
                        new Solution.TreeNode(7)),
                new Solution.TreeNode(6,
                        new Solution.TreeNode(7),
                        new Solution.TreeNode(5)));

        System.out.println(solver.isSymmetrical(root));
    }
}

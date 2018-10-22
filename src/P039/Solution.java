package P039;

/*
 * Created by tonyke on 21/10/2018
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int checkBalanceOfBTree(TreeNode root) {
        if (root == null) return 0;


        int leftHeight = checkBalanceOfBTree(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkBalanceOfBTree(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return checkBalanceOfBTree(root) != -1;
    }
}

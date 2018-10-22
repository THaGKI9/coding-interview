package P004;

import java.util.Stack;

/**
 * Created by tonyke on 18/10/2018
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

    public TreeNode buildTree(Stack<Integer> pre, int[] in, int left, int right) {
        TreeNode root = new TreeNode(pre.pop());

        int inIndex = left;
        while (in[inIndex] != root.val) inIndex++;

        if (left <= inIndex - 1) {
            root.left = buildTree(pre, in, left, inIndex - 1);
        }

        if (right >= inIndex + 1) {
            root.right = buildTree(pre, in, inIndex + 1, right);
        }

        return root;
    }

    public void printTree(String indent, TreeNode root) {
        if (root == null) return;
        if (root.left != null) printTree(indent + " ", root.left);
        System.out.println(String.format("%s%s", indent, root.val));
        if (root.right != null) printTree(indent + " ", root.right);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length) return null;
        if (pre.length == 0) return null;

        Stack<Integer> preOrder = new Stack<>();
        for (int i = pre.length - 1; i >= 0; --i) preOrder.push(pre[i]);

        /*
        1) Pick an element from pre-order.
            Increment a pre-order Index Variable (preIndex in below code) to pick next element in next recursive call.
        2) Create a new tree node tNode with the data as picked element.
        3) Find the picked element’s index in in-order. Let the index be inIndex.
        4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
        5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
        6) return tNode.
        */

        return buildTree(preOrder, in, 0, pre.length - 1);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        var tree = solver.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        solver.printTree("", tree);
    }

}

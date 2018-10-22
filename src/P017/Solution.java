package P017;

/**
 * Created by tonyke on 9/10/2018
 */
public class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean compareTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;

        if (!compareTree(root1.left, root2.left)) return false;
        if (!compareTree(root1.right, root2.right)) return false;

        return true;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        /**
         * find root2.val in root1
         * and compare two nodes
         */
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            boolean found = compareTree(root1, root2);
            if (found) return true;
        }

        return (root1.left != null && HasSubtree(root1.left, root2))
                || (root2.right != null && HasSubtree(root1.right, root2));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8,
                new TreeNode(8,
                        new TreeNode(9),
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(7))),
                new TreeNode(7)
        );

        TreeNode treeA = new TreeNode(8,
                new TreeNode(9),
                new TreeNode(2));

        Solution solver = new Solution();
        System.out.println(solver.HasSubtree(root, treeA));

    }
}

package P026;

/**
 * Created by tonyke on 11/10/2018
 * <p>
 * 二叉搜索树与双向链表
 * 思路：
 * 对于每一个节点，把左儿子的 right 指向父节点，父节点的 left 指向左儿子
 * 右儿子反之
 *
 * 但是对于左儿子，要将指针移动到左儿子最大的那个数上，也就是最 right 的那一头
 * 对于右儿子，要移动到最 left 那一头
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

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        TreeNode leftNode = Convert(pRootOfTree.left);
        TreeNode rightNode = Convert(pRootOfTree.right);

        if (leftNode != null) {
            while (leftNode.right != null) leftNode = leftNode.right;
            leftNode.right = pRootOfTree;
            pRootOfTree.left = leftNode;
        }

        if (rightNode != null) {
            rightNode.left = pRootOfTree;
            pRootOfTree.right = rightNode;
        }

        while (pRootOfTree.left != null) pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }
}
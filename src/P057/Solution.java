package P057;

/**
 * Created by tonyke on 12/10/2018
 * 二叉树的下一个结点
 * 思路：
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeLinkNode dfs(TreeLinkNode pNode, TreeLinkNode lastNode, TreeLinkNode findingNode) {
        //
        if (pNode.left != null) dfs(pNode.left, lastNode, findingNode);
        // N, process
        if (lastNode == findingNode) return pNode;
        lastNode = pNode;
        // R
        if (pNode.right != null) dfs(pNode.right, lastNode, findingNode);
        return null;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        TreeLinkNode root = pNode;
        while (root.next != null) root = root.next;

        TreeLinkNode result = dfs(root, null, pNode);
        return result;
    }
}

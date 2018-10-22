package P022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tonyke on 10/10/2018
 *
 * 从上往下打印二叉树
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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rv = new ArrayList<>();
        Queue<TreeNode> currentLayer;
        Queue<TreeNode> nextLayer = new LinkedList<>();

        if (root != null) nextLayer.add(root);

        while (nextLayer.size() != 0) {
            currentLayer = nextLayer;
            nextLayer = new LinkedList<>();

            while (currentLayer.size() > 0) {
                TreeNode node = currentLayer.poll();
                rv.add(node.val);

                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
            }
        }

        return rv;
    }
}

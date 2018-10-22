package P059;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tonyke on 15/10/2018
 * 按之字形顺序打印二叉树
 * 思路：
 * BFS
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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<TreeNode> currentLayer;
        ArrayList<TreeNode> nextLayer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) return result;
        boolean leftToRight = true;

        nextLayer.add(pRoot);

        while (!nextLayer.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            currentLayer = nextLayer;
            nextLayer = new ArrayList<>();

            for (TreeNode treeNode : currentLayer) {
                row.add(treeNode.val);
                if (treeNode.left != null) nextLayer.add(treeNode.left);
                if (treeNode.right != null) nextLayer.add(treeNode.right);
            }

            if (!leftToRight) Collections.reverse(row);
            result.add(row);

            leftToRight = !leftToRight;
        }

        return result;
    }
}

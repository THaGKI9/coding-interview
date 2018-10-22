package P024;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tonyke on 10/10/2018
 * <p>
 * 二叉树中和为某一值的路径
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> routes = new ArrayList<>();

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void dfs(TreeNode curr, int distance, Stack<Integer> route) {
        distance -= curr.val;
        route.push(curr.val);

        if (distance == 0) {
            boolean canBeTheEnd = curr.left == null || curr.right == null;
            if (canBeTheEnd) {
                ArrayList<Integer> newStack = new ArrayList<>();
                newStack.addAll(route);
                routes.add(newStack);
            }
        } else if (distance < 0) {
        } else {
            if (curr.left != null) dfs(curr.left, distance, route);
            if (curr.right != null) dfs(curr.right, distance, route);
        }

        route.pop();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null) dfs(root, target, new Stack<>());
        routes.sort((lhs, rhs) -> rhs.size() - lhs.size());
        return routes;
    }
}

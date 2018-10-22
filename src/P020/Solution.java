package P020;

/**
 * Created by tonyke on 10/10/2018
 *
 * 包含min函数的栈
 */
public class Solution {
    class Node {
        public int val;
        public Node prev;
        public int minPrev;

        public Node(int val, int minPrev, Node prev) {
            this.val = val;
            this.prev = prev;
            this.minPrev = minPrev;
        }
    }

    Node current = null;
    int minVal = Integer.MAX_VALUE;

    public void push(int node) {
        Node prevNode = current;
        current = new Node(node, minVal, prevNode);
        minVal = Math.min(minVal, node);
    }

    public void pop() {
        if (current == null) return;
        minVal = current.minPrev;
        current = current.prev;
    }

    public int top() {
        return current == null ? -1 : current.val;
    }

    public int min() {
        return current == null ? -1 : minVal;
    }
}
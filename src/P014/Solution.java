package P014;

import java.util.ArrayList;

/**
 * Created by tonyke on 9/10/2018
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0) return null;

        ArrayList<ListNode> fixedSizeStack = new ArrayList<>(k);

        while (head != null) {
            if (fixedSizeStack.size() >= k) fixedSizeStack.remove(0);
            fixedSizeStack.add(head);
            head = head.next;
        }

        if (fixedSizeStack.size() != k) return null;
        return fixedSizeStack.get(0);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        var node1 = new Solution.ListNode(1);
        var node2 = new Solution.ListNode(2);
        var node3 = new Solution.ListNode(3);
        var node4 = new Solution.ListNode(4);
        var node5 = new Solution.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        var result = solver.FindKthToTail(node1, 6);
        System.out.println(result);
    }
}

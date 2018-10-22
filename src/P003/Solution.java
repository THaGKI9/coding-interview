package P003;

import java.util.ArrayList;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> tailedValues = new ArrayList<>();

        while (listNode != null) {
            values.add(listNode.val);
            listNode = listNode.next;
        }

        for (int i = values.size() - 1; i >= 0; i--) {
            tailedValues.add(values.get(i));
        }

        return tailedValues;
    }
}
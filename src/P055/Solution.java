package P055;

import java.util.HashSet;

/**
 * Created by tonyke on 12/10/2018
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> visited = new HashSet<>();

        while (pHead != null) {
            if (visited.contains(pHead)) return pHead;
            visited.add(pHead);
            pHead = pHead.next;
        }

        return null;
    }
}
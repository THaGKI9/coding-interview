package P056;

import java.util.HashMap;

/**
 * Created by tonyke on 12/10/2018
 * 删除链表中重复的结点
 * 思路：
 * 遍历链表，计数，再遍历列表来删除
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode originalHead = pHead;
        HashMap<Integer, Integer> times = new HashMap<>();

        while (pHead != null) {
            times.put(pHead.val, times.getOrDefault(pHead.val, 0) + 1);
            pHead = pHead.next;
        }

        pHead = originalHead;
        ListNode rv = null;
        ListNode rvHead = null;
        // process head
        while (pHead != null) {
            if (times.get(pHead.val) > 1) continue;
            if (rv == null) {
                rv = pHead;
                rvHead = pHead;
            } else {
                rvHead.next = pHead;
                rvHead = rvHead.next;
            }
            pHead = pHead.next;
        }

        if (rvHead != null) rvHead.next = null;
        return rv;
    }
}

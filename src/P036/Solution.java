package P036;

import java.util.HashSet;

/**
 * Created by tonyke on 19/10/2018
 * 两个链表的第一个公共结点
 * 思路：
 * 不太理解公共节点的意思是节点的引用相同还是节点的 val 相同
 * 都试试吧
 * 随便选一条链表过一下，标记一下某个节点是否访问过
 * 遍历另外一条链表，检查是否访问过
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<Integer> visited = new HashSet<>();
        while (pHead1 != null) {
            visited.add(pHead1.val);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (visited.contains(pHead2.val)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }

        return null;
    }
}
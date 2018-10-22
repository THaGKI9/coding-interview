package P015;

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

    public ListNode ReverseList(ListNode head) {
        ListNode lastNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = nextNode;
        }
        return lastNode;
    }
}

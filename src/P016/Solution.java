package P016;

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

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            // swap list1 and list2, make head of list1 to be the smaller one
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        ListNode rv = list1;
        ListNode current = list1;
        list1 = list1.next;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                break;
            }

            if (list2 == null) {
                current.next = list1;
                break;
            }

            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        return rv;
    }
}

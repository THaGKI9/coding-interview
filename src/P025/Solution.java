package P025;

import java.util.HashMap;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * Created by tonyke on 10/10/2018
 * <p>
 * 复杂链表的复制
 * <p>
 * 思路：
 * 复制主链，同时建立起一个旧节点到新节点的映射，先直接把旧节点的 random 赋值到新节点
 * 复制完主链之后，遍历新的链表，把 random 根据原来建立的映射更新一遍
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> oldToNewRelation = new HashMap<>();

        RandomListNode originalHead = new RandomListNode(0);
        originalHead.next = pHead;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode root = newHead;

        while (originalHead.next != null) {
            newHead.next = new RandomListNode(originalHead.next.label);
            newHead.next.random = originalHead.next.random;

            newHead = newHead.next;
            originalHead = originalHead.next;

            oldToNewRelation.put(originalHead, newHead);
        }

        pHead = root.next;
        while (pHead != null) {
            pHead.random = oldToNewRelation.get(pHead.random);
            pHead = pHead.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        RandomListNode node6 = new RandomListNode(6);
        RandomListNode node7 = new RandomListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Solution solver = new Solution();
        RandomListNode node = solver.Clone(node1);

        System.out.println(node);
    }
}

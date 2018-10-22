package P023;

/**
 * Created by tonyke on 10/10/2018
 * 二叉搜索树的后序遍历序列
 * 思路：
 * BST后序遍历的序列有个特点，就是在序列里面存在一个分界点，分界点的左边的节点都要比序列最后一个要小，右边的大
 * 照这个思路递归验证一下就行
 */
public class Solution {
    public boolean ValidateBSTPostOrder(int[] sequence, int left, int right) {
        int rootVal = sequence[right];
        int peekPoint = left;

        while (sequence[peekPoint] < rootVal) peekPoint++;
        if (peekPoint != right) {
            int tmpIndex = peekPoint;
            while (sequence[tmpIndex] > rootVal) tmpIndex++;
            if (tmpIndex != right) return false;
        }

        if (peekPoint != left && peekPoint - 1 != left) {
            if (!ValidateBSTPostOrder(sequence, left, peekPoint - 1)) return false;
        }

        if (peekPoint != right && peekPoint + 1 != right) {
            if (!ValidateBSTPostOrder(sequence, peekPoint, right - 1)) return false;
        }

        return true;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;

        return ValidateBSTPostOrder(sequence, 0, sequence.length - 1);
    }
}
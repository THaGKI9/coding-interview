package P040;

/**
 * Created by tonyke on 21/10/2018
 * 思路：
 * 用异或的操作方法，两个相同的数进行异或会互相抵消
 * 得到结果之后，用最高位的 1bit 来分离两个数
 */
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length <= 1) return;
        if (array.length == 2) {
            if (array[0] == array[1]) {
                num1[0] = array[0];
                num2[0] = array[1];
            }
            return;
        }

        int totalXor = 0;
        for (int i : array) totalXor ^= i;

        int bitDetector = 0x80000000;
        while (bitDetector != 0 && (bitDetector & totalXor) == 0) bitDetector >>>= 1;

        num1[0] = 0;
        num2[0] = 0;
        for (int i : array) {
            if ((bitDetector & i) != 0) num1[0] ^= i;
            else num2[0] ^= i;
        }
    }

    public static void main(String args[]) {
        Solution solver = new Solution();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solver.FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);

        System.out.println(String.format("%d,%d", num1[0], num2[0]));
    }
}

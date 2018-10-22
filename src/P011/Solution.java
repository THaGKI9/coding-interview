package P011;

/**
 * Created by tonyke on 18/10/2018
 * 二进制中1的个数
 * 思路：
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count += 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.NumberOf1(-2147483648));
    }
}

package P048;

/**
 * Created by tonyke on 12/10/2018
 *
 * 不用加减乘除做加法
 *
 * 用二进制
 * 模拟进位
 */
public class Solution {

    public static int Add(int num1, int num2) {
        int a = num1 ^ num2;
        int b = num1 & num2;
        int c = b << 1;
        if (b != 0) {
            int end = Add(a, c);
            a = end;
        }

        return a;
    }
}

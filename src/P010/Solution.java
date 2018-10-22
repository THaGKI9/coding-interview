package P010;

/**
 * Created by tonyke on 9/10/2018
 * 思路：
 * 想了很久，想不出来，最后在网上查到的
 * f(n) = f(n - 1) + f(n - 2) Fibonacci.....
 * 原理就是对于 f(n)，他的摆放方式只有两种，f(n - 1) 之后再放一块，f(n - 2) 之后放两块
 */
public class Solution {
    public int RectCover(int target) {
        int fn1 = 1;
        int fn2 = 0;

        if (target == 0) return 0;

        while (target-- > 0) {
            int tmp = fn1 + fn2;
            fn2 = fn1;
            fn1 = tmp;
        }

        return fn1;
    }

    public static void main(String args[]) {
        Solution solver = new Solution();
        System.out.println(solver.RectCover(5));
    }
}

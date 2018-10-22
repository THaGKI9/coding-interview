package P047;

/**
 * Created by tonyke on 12/10/2018
 *
 * 求1+2+3+...+n
 * 思路：
 * 不能用循环，不能条件判断，不能用乘除
 *
 */
public class Solution {
    public int sum = 0;

    public void dfs(int n) {
        boolean a = n > 0 && Sum_Solution(n - 1) > 0;
        sum += n;
    }

    public int Sum_Solution(int n) {
        dfs(n);
        return sum;
    }
}

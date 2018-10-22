package P009;

/**
 * Created by tonyke on 9/10/2018
 *
 * 变态跳台阶
 */
public class Solution {
    /**
     * f(n) = | 0, n = 0
     *        | 1, n = 1
     *        | f(n - 1) * 2, n = 2, 3, ...
     *
     * f(n) = 2^(n-1), n >= 1
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target == 1) return 1;

        int count = 1;
        while (target > 1) count *= 2;

        return count;
    }
}

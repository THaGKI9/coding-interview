package P008;

import java.math.BigInteger;

/**
 * Created by tonyke on 9/10/2018
 *
 * 跳台阶
 */
public class Solution {
    /**
     * @param step1 times of 1 step
     * @param step2 times of 2 steps
     * @return count of combinations
     */
    public BigInteger calcCombs(int step1, int step2) {
        BigInteger count = BigInteger.valueOf(1); // m * (m - 1) * ... * (m - n + 1) / n!
        int m = step1 + step2;  // balls
        int n = step1 < step2 ? step1 : step2;  // balls to take away
        int i = m - n + 1;
        while (i <= m) count = count.multiply(BigInteger.valueOf(i++));
        while (n >= 1) count = count.divide(BigInteger.valueOf(n--));
        return count;
    }

    public int JumpFloor(int target) {
        BigInteger count = BigInteger.valueOf(0);
        for (int step1 = 0; step1 <= target; step1++) {
            if ((target - step1) % 2 == 1) continue;

            int step2 = (target - step1) / 2;
            BigInteger combs = calcCombs(step1, step2);
            count = count.add(combs);
        }
        return count.intValueExact();
    }

    public static void main(String[] main) {
        Solution solver = new Solution();
        System.out.println(solver.JumpFloor(29));
    }
}
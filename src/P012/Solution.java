package P012;

/**
 * Created by tonyke on 9/10/2018
 */
public class Solution {
    public double Power(double base, int exponent) {
        boolean reverse = exponent < 0;
        exponent = Math.abs(exponent);
        double rv = 1;
        while (exponent-- > 0) rv *= base;

        if (reverse) return 1 / rv;
        else return rv;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.Power(2.1475, 5));
        System.out.println(solver.Power(2.1475, -5));
    }
}

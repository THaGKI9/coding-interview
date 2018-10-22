package P053;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 表示数值的字符串
 */
public class Solution {
    // "+100","5e2","-123","3.1416"和"-1E-16"
    public boolean isNumeric(char[] str) {
        boolean startExponent = false;
        boolean closeExponent = false;
        boolean startDecimal = false;
        boolean closeDecimal = false;
        boolean hasSign = false;
        boolean startSignOnExponent = false;
        boolean closeSignOnExponent = false;

        for (char c : str) {
            switch (c) {
                case '+':
                case '-':
                    if (hasSign && !startExponent) return false;
                    if (startExponent && startSignOnExponent) return false;
                    if (startExponent) startSignOnExponent = true;
                    break;

                case '.':
                    if (startDecimal || startExponent) return false;
                    startDecimal = true;
                    break;

                case 'e':
                case 'E':
                    if (startDecimal && !closeDecimal) return false;
                    startExponent = true;
                    startDecimal = true;
                    closeDecimal = true;
                    break;

                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (startDecimal) closeDecimal = true;
                    if (startExponent) closeExponent = true;
                    if (startSignOnExponent) closeSignOnExponent = true;

            }

            hasSign = true;
        }


        return str.length > 0
                && startExponent == closeExponent
                && startDecimal == closeDecimal
                && startSignOnExponent == closeSignOnExponent;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.print("123  ");
        System.out.println(solver.isNumeric("123".toCharArray()));
        System.out.print("+123  ");
        System.out.println(solver.isNumeric("+123".toCharArray()));
        System.out.print("-123  ");
        System.out.println(solver.isNumeric("-123".toCharArray()));
        System.out.print("123.0  ");
        System.out.println(solver.isNumeric("123.0".toCharArray()));
        System.out.print("+123.0  ");
        System.out.println(solver.isNumeric("+123.0".toCharArray()));
        System.out.print("1e1  ");
        System.out.println(solver.isNumeric("1e1".toCharArray()));
        System.out.print("1.1e1  ");
        System.out.println(solver.isNumeric("1.1e1".toCharArray()));
        System.out.print("+1.1e1  ");
        System.out.println(solver.isNumeric("+1.1e1".toCharArray()));
        System.out.print("+1E-1  ");
        System.out.println(solver.isNumeric("+1E-1".toCharArray()));
        System.out.print("+123.45e+6  ");
        System.out.println(solver.isNumeric("+123.45e+6".toCharArray()));
        System.out.print("1.1E1  ");
        System.out.println(solver.isNumeric("1.1E1".toCharArray()));
        System.out.print("1.E1  ");
        System.out.println(solver.isNumeric("1.E1".toCharArray()));
        System.out.print("  ");
        System.out.println(solver.isNumeric("".toCharArray()));

    }
}
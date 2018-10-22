package P049;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 把字符串转换成整数
 * 思路：
 * 没什么好讲的，注意符号
 */
public class Solution {
    public int StrToInt(String str) {
        String source = str.trim();

        if (source.length() == 0) return 0;
        boolean sign = true;  // true for positive
        int rv = 0;

        if (source.charAt(0) == '-') sign = false;
        if (source.charAt(0) == '-' || source.charAt(0) == '+') source = source.substring(1);

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c < '0' || c > '9') return 0;

            int val = c - '0';
            rv = rv * 10 + val;
        }

        return sign ? rv : -rv;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.print(solver.StrToInt("+123"));
    }
}
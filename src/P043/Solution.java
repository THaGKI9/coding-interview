package P043;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 左旋转字符串
 * 思路：
 * 先把 n %= str.length
 * 然后取子字符串来拼接
 */
public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) return str;

        n %= str.length();
        if (n == 0) return str;

        return str.substring(n) + str.substring(0, n);
    }
}

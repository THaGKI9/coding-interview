package P002;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(str.charAt(i));
            }
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        var solver = new Solution();
        System.out.println(solver.replaceSpace(new StringBuffer("12 1203120 102403124")));
    }
}
